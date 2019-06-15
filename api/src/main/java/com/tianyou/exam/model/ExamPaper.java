package com.tianyou.exam.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者 XJB
 * 功能描述 : 试卷
 * 日期 2019/6/10 16:33
 */
//@Table(name = "ty_exam_paper")
public class ExamPaper implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * id主键
     */
   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * 总分数
     */
    // @Column(name = "total_score")
    private int totalScore;

    /**
     * 考试时间
     */
    /// @Column(name = "exam_time")
    private String examTime;
    /**
     *考试模板id
     */
    // @Column(name = "examination_template_id")
    private int examinationTemplateId;

    /**
     *试题id
     */
    // @Column(name = "exam_question_id")
    private int examQuestionId;
    /**
     * 创建时间
     */
   /// @Column(name = "create_date")
    private Date createDate;

    /**
     * 创建人
     */
   // @Column(name = "create_by")
    private String createBy;

    /**
     * 修改人
     */
   // @Column(name = "update_by")
    private String updateBy;

    /**
     * 删除标识符
     */
    private int delflag;

    /**
     * 修改时间
     */
    //@Column(name = "update_date")
    private Date updateDate;

    /**
     * 状态
     */
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public int getExaminationTemplateId() {
        return examinationTemplateId;
    }

    public void setExaminationTemplateId(int examinationTemplateId) {
        this.examinationTemplateId = examinationTemplateId;
    }

    public int getExamQuestionId() {
        return examQuestionId;
    }

    public void setExamQuestionId(int examQuestionId) {
        this.examQuestionId = examQuestionId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
