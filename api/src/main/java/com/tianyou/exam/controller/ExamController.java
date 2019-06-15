package com.tianyou.exam.controller;

import com.alibaba.fastjson.JSON;
import com.tianyou.exam.model.ExamPaper;
import com.tianyou.exam.model.ExaminationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //生成考试模板
    @RequestMapping(path = "/template", method = RequestMethod.POST)
    public String createQuesionBank(@Valid ExaminationTemplate examinationTemplate, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return JSON.toJSONString(ApiResponse.FAIL(bindingResult.getAllErrors().toString()));
        }

        examinationTemplate.setCreateDate(new Date());
        examinationTemplate.setCreateBy("admin");
        examinationTemplate.setDelflag(0);
        examinationTemplate.setStatus(0);
        jdbcTemplate.update("insert into ty_examination_template(id,examination_name,template_type_dic_id,create_by,create_date,status,delflag) values (:id,:examinationName,:examinationTypeDicId,:createBy,:createDate,:status,:delflag)", new BeanPropertySqlParameterSource(examinationTemplate));
        return JSON.toJSONString(ApiResponse.OK());
    }

    //查看考试模板
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String queryList() {

        List<ExaminationTemplate> list = jdbcTemplate.query("select * from ty_examination_template", new RowMapper<ExaminationTemplate>() {
            @Override
            public ExaminationTemplate mapRow(ResultSet rs, int rowNum) throws SQLException {
                ExaminationTemplate examinationTemplate = new ExaminationTemplate();
                examinationTemplate.setId(rs.getInt("id"));
                examinationTemplate.setExaminationName(rs.getString("examination_name"));
                examinationTemplate.setExaminationTypeDicId(rs.getInt("template_type_dic_id"));
                examinationTemplate.setStatus(0);
                examinationTemplate.setDelflag(0);
                return examinationTemplate;
            }
        });

        return JSON.toJSONString(ApiResponse.OK().data(list));
    }
    //生成试卷
   @RequestMapping(path = "/exampaper", method = RequestMethod.POST)
    public String createExamPaper(@Valid ExamPaper examPaper, BindingResult bindingResult) {

       if (bindingResult.hasErrors()) {
            return JSON.toJSONString(ApiResponse.FAIL(bindingResult.getAllErrors().toString()));
        }

       examPaper.setCreateDate(new Date());
       examPaper.setCreateBy("admin");
       examPaper.setDelflag(0);
       examPaper.setStatus(0);
        jdbcTemplate.update("insert into ty_exam_paper(id,total_score,exam_time,examination_template_id,exam_question_id,create_by,create_date,status,delflag) values (:id,:totalScore,:examTime,:examinationTemplateId,:examQuestionId,:createBy,:createDate,:status,:delflag)", new BeanPropertySqlParameterSource(examPaper));
        return JSON.toJSONString(ApiResponse.OK());
    }
    //查看试卷
    @RequestMapping(path = "/examlist", method = RequestMethod.GET)
    public String examPaperList() {

        List<ExamPaper> list = jdbcTemplate.query("select * from ty_exam_paper", new RowMapper<ExamPaper>() {
            @Override
            public ExamPaper mapRow(ResultSet rs, int rowNum) throws SQLException {
                ExamPaper examPaper = new ExamPaper();
                examPaper.setId(rs.getInt("id"));
                examPaper.setTotalScore(rs.getInt("total_score"));
                examPaper.setExamTime(rs.getString("exam_time"));
                examPaper.setExaminationTemplateId(rs.getInt("examination_template_id"));
                examPaper.setExamQuestionId(rs.getInt("exam_question_id"));
                examPaper.setStatus(0);
                examPaper.setDelflag(0);
                return examPaper;
            }
        });

        return JSON.toJSONString(ApiResponse.OK().data(list));
    }

}
