#!/usr/bin/env bash

APP_RUNNER="com.tianyou.exam.ExamApplication"

function is_process_running {
  local  pid=$1
  kill -0 $pid > /dev/null 2>&1 #exit code ($?) is 0 if pid is running, 1 if not running
  local  status=$?              #because we are returning exit code, can use with if & no [ bracket
  return $status
}


PRG="$0"
PRGDIR=`dirname "$PRG"`
[ -z "$APP_HOME" ] && APP_HOME=`cd "$PRGDIR/.." >/dev/null; pwd`

currentpidfile="${APP_HOME}/currentpid"

if [[ -f "$currentpidfile" ]] ; then
  if is_process_running $(<$currentpidfile) ; then
    echo "Process already running [pid: $(<$currentpidfile)]. Aborting"
    exit 1
  fi
fi

if [ -f /config/logback.xml ]; then
    echo "Found logback.xml"
else
  echo "with error: /config/logback.xml doesn't exist."
fi

APP_LOGS_DIR="${APP_HOME}/logs"

JAVA_OPTS=" -Xms4G -Xmx4G -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:NewRatio=3"

if [ ! -d "${APP_HOME}/logs" ]; then
    mkdir -p "${APP_LOGS_DIR}"
fi


CLASSPATH="$APP_HOME/conf:$CLASSPATH"
for i in "$APP_HOME"/lib/*.jar
do
    CLASSPATH="$i:$CLASSPATH"
done

echo "Starting app...."
eval exec "java ${JAVA_OPTS} -classpath $CLASSPATH  ${APP_RUNNER}"

retval=$?
pid=$!
FAIL_MSG="app started failure!"
SUCCESS_MSG="app started successfully!"
[ ${retval} -eq 0 ] || (echo ${FAIL_MSG}; exit ${retval})
sleep 1
if ! ps -p ${pid} > /dev/null ; then
    echo ${FAIL_MSG}
    exit 1
fi

echo $! > $APP_HOME/currentpid


echo ${SUCCESS_MSG}