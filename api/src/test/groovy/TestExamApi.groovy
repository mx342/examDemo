import spock.lang.Specification

class TestExamApi extends Specification implements Testable {


    def status() {

        def path = "/status/version"
        when:

        def response = get(path, [:])
        then:

        response == "成功"

    }


    def question() {

        def path = "/question/bank"

        when:

        def response = postAsMap(path, [name: "安全"])

        then:

        response["code"] == 0


        when:

        def listQuery = getAsMap("/question/list", [:])


        then:
        response["code"] == 0
        listQuery["data"].size() > 0

    }


    //S.s创建试题
    def questionTest() {

        def path = "/question/addQuestion"

        when:

        def response = postAsMap(path, [questionTrunk: "可不可以不要这个奖？", answer:"[{\"A\": \"到底\",\"B\":\"还有\",\"C\":\"多少关\",\"D\":\"？\"}]", rightAnswer:"B", questionTypeId:"1", questionBankId:"1"])

        then:

        response["code"] == 0

    }

}
