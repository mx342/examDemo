package com.tianyou.exam.controller;

import com.alibaba.fastjson.JSON;
import com.tianyou.exam.model.Question;
import com.tianyou.exam.model.QuestionBank;
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
@RequestMapping(path = "/question")
public class QuestionController {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    //添加题库
    @RequestMapping(path = "/bank", method = RequestMethod.POST)
    public String createQuesionBank(@Valid QuestionBank questionBank, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return JSON.toJSONString(ApiResponse.FAIL(bindingResult.getAllErrors().toString()));
        }

        questionBank.setCreateBy("main");

        jdbcTemplate.update("insert into ty_question_bank(name,create_by,create_date) values (:name,:createBy,:createDate)", new BeanPropertySqlParameterSource(questionBank));
        return JSON.toJSONString(ApiResponse.OK());
    }


    //查找题库
    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String queryList() {

        List<QuestionBank> list = jdbcTemplate.query("select * from ty_question_bank", new RowMapper<QuestionBank>() {
            @Override
            public QuestionBank mapRow(ResultSet rs, int rowNum) throws SQLException {
                QuestionBank questionBank = new QuestionBank();
                questionBank.setName(rs.getString("name"));
                return questionBank;
            }
        });

        return JSON.toJSONString(ApiResponse.OK().data(list));
    }

    //删除题库

    //更改题库




    //添加试题
    @RequestMapping(path = "/addQuestion", method = RequestMethod.POST)
    public String createQuesion(@Valid Question question, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return JSON.toJSONString(ApiResponse.FAIL(bindingResult.getAllErrors().toString()));
        }

        question.setCreateBy("main");
        question.setStatus(0);
        question.setDelflag(0);

        jdbcTemplate.update("INSERT INTO ty_test_question ( question_trunk,answer,right_answer,question_type_id,question_bank_id,create_by,create_date )\n" +
                "VALUES\n" +
                "( :questionTrunk,:answer,:rightAnswer,:questionTypeId,:questionBankId,:createBy,:createDate )", new BeanPropertySqlParameterSource(question));
        return JSON.toJSONString(ApiResponse.OK());
    }


    //查找试题
    @RequestMapping(path = "/questionList", method = RequestMethod.GET)
    public String queryQuestionList() {

        List<Question> questionList = jdbcTemplate.query("select * from ty_test_question", new RowMapper<Question>() {
            @Override
            public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
                Question question = new Question();
                question.setQuestionTrunk(rs.getString("questionTrunk"));
                question.setAnswer(rs.getString("answer"));
                question.setRightAnswer(rs.getString("rightAnswer"));
                question.setQuestionTypeId(rs.getInt("questionTypeId"));
                question.setQuestionBankId(rs.getInt("questionBankId"));
                return question;
            }
        });

        return JSON.toJSONString(ApiResponse.OK().data(questionList));
    }


    //删除试题

    //更改试题
}
