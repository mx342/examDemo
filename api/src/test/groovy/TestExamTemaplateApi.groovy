import spock.lang.Specification

class TestExamTemaplateApi extends Specification implements Testable {

    def examinationTemplate() {

        def path = "/exam/template"

        when:

        def response = postAsMap(path,[examinationName: "司机模板考试",
         examinationTypeDicId: 1])

        then:

        response["code"] == 0


        when:

        def listQuery = getAsMap("/exam/list", [:])


        then:
        listQuery["data"].size() > 0

    }

    def examPaper() {

        def path = "/exam/exampaper"

        when:
1
            def response = postAsMap(path,[totalScore: 300,examTime: "120分钟",examinationTemplateId: 1,examinationTemplateId: 1
                                           ,examQuestionId:1])

        then:

        response["code"] == 0


        when:

        def listQuery = getAsMap("/exam/examlist", [:])


        then:
        listQuery["data"].size() > 0

    }

}
