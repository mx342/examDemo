package com.tianyou.exam.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 作者 XJB
 * 功能描述 : 考试模板
 * 日期 2019/6/10 16:33
 */
//@Table(name = "ty_examination_template")
public class ExaminationTemplate implements Serializable {

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
     * 模板名称
     */
    // @Column(name = "examination_name")
    private String examinationName;
    /**
     * 分类类型id  关联字典表
     */
    // @Column(name = "template_type_dic_id")
    private int examinationTypeDicId;

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

    public String getExaminationName() {
        return examinationName;
    }

    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName;
    }


    public int getExaminationTypeDicId() {
        return examinationTypeDicId;
    }

    public void setExaminationTypeDicId(int examinationTypeDicId) {
        this.examinationTypeDicId = examinationTypeDicId;
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
