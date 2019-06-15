#!/usr/bin/env bash
set -o nounset


function is_process_running {
  local  pid=$1
  kill -0 $pid > /dev/null 2>&1 #exit code ($?) is 0 if pid is running, 1 if not running
  local  status=$?              #because we are returning exit code, can use with if & no [ bracket
  return $status
}

function kill_process_with_retry {
   local pid="$1"
   local pname="$2"
   local maxattempt="$3"
   local sleeptime=5

   if ! is_process_running $pid ; then
     echo "ERROR: process name ${pname} with pid: ${pid} not found"
     exit 1
   fi

   for try in $(seq 1 $maxattempt); do
      echo "Killing $pname. [pid: $pid], attempt: $try"
      kill ${pid}
      sleep 5
      if is_process_running $pid; then
        echo "$pname is not dead [pid: $pid]"
        echo "sleeping for $sleeptime seconds before retry"
        sleep $sleeptime
      else
        echo "shutdown succeeded"
        return 0
      fi
   done

   echo "Error: unable to kill process for $maxattempt attempt(s), killing the process with -9"
   kill -9 $pid
   sleep $sleeptime

   if is_process_running $pid; then
      echo "$pname is not dead even after kill -9 [pid: $pid]"
      return 1
   else
    echo "shutdown succeeded"
    return 0
   fi
}


installdir="$(dirname $0)/.."
maxattempt=3
pid=`cat ${installdir}/currentpid`
pname="app"

kill_process_with_retry "${pid}" "${pname}" "${maxattempt}"

if [[ $? == 0 ]]; then
  rm -f ${installdir}/currentpid
  exit 0
else
  exit 1
fi