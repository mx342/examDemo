import com.alibaba.fastjson.JSON
import jodd.http.HttpRequest

trait Testable {

    private def baseUrl = "http://localhost:8080"

    def get(url, Map map) {
        HttpRequest.get(baseUrl + url).query(map).send().bodyText()
    }

    def getAsMap(url, Map map) {
        asMap(HttpRequest.get(baseUrl + url).query(map).send().bodyText())
    }

    def postAsMap(url, Map map) {
        def bodytest = HttpRequest.post(baseUrl + url).form(map).send().bodyText()
        asMap(bodytest)
    }

    def postAsMap(server, url, Map map, String name, String value) {
        def bodytest = HttpRequest.post(server + url).form(map).header(name, value).send().bodyText()
        asMap(bodytest)
    }


    def postAsMap(url, Map map, String name, String value) {
        def bodytest = HttpRequest.post(baseUrl + url).form(map).header(name, value).send().bodyText()
        asMap(bodytest)
    }

    def postBody(url, Map map) {
        def bodytest = HttpRequest.post(url).body(JSON.toJSONString(map)).send().bodyText()
        asMap(bodytest)
    }

    def postFile(path, File file, String name, String value) {
        def res = HttpRequest.post(baseUrl + path).form("file", file).header(name, value).send().bodyText()
        asMap(res)
    }

    def postFile(url, File file) {
        def res = HttpRequest.post(url).form("file", file).send().bodyText()
        asMap(res)
    }


    def postUrlAsMap(url, Map map) {
        asMap(HttpRequest.post(url).form(map).send().bodyText())
    }

    def postAsList(url, Map map) {
        JSON.parseObject(HttpRequest.post(baseUrl + url).form(map).send().bodyText(), List.class)
    }


    def asMap(def json) {
        JSON.parseObject(json, Map.class)
    }


    def checkError(errors) {
        if (errors instanceof com.google.gson.internal.LinkedTreeMap) {
            return errors["status"] == 400
        }

        errors.every { it["status"] == 400 }
    }

    def checkError(errors, status) {
        if (errors instanceof com.google.gson.internal.LinkedTreeMap) {
            return errors["status"] == status
        }

        errors.every { it["status"] == status }
    }

    def checkCorrect(corrects) {
        if (corrects instanceof com.google.gson.internal.LinkedTreeMap) {
            return corrects["status"] == 200
        }

        corrects.every { it["status"] == 200 }
    }


    def checkAnyError(corrects) {
        corrects.any { it["status"] == 400 || it["status"] == 500 }
    }
}