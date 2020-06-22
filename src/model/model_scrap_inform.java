package model;

import java.util.Date;

public class model_scrap_inform {

	private int id;
    private String scrap_date;
    private Date scrap_date_d;
    private int factory_id;
    private String fac_name;
    private int pd_group;
    private String pd_group_name;
    private int pd_process;
    private String process_name;
    private int mat_type;
    private String mattype_name;
    private int scrap_type;
    private String scraptype_name;
    private double scrap_Quatity;
    private int scrap_unit;
    private String scp_unit_name;
    private int scrap_typeboi_id;
    private String scrap_typeboi_name;
    private double scrap_Weight;
    private double conform_Weight;
    private int scrap_code_id;
    private String scrap_code;
    private double qty_total;
    private double qty_boi;
    private String str_qty_boi;
    private double qty_non_boi;
    private String str_qty_non_boi;
    private String str_qty_total;
    private int sc_type_num;
    private String sc_big_type;
    private double p_qty_boi;
    private String p_str_qty_boi;
    private double p_qty_non_boi;
    private String p_str_qty_non_boi;
    private double p_qty_total;
    private String p_str_qty_total;
    private double sum_pd_boi;
    private double sum_sc_boi;
    private double sum_pd_non_boi;
    private double sum_sc_non_boi;
    private double sum_pd_total;
    private double sum_sc_total;
    private double pd_qty_boi;
    private double sc_qty_boi;
    private double pd_qty_non_boi;
    private double sc_qty_non_boi;
    private double pd_qty_total;
    private double sc_qty_total;
    
    
    public double getPd_qty_boi() {
		return pd_qty_boi;
	}
	public void setPd_qty_boi(double pd_qty_boi) {
		this.pd_qty_boi = pd_qty_boi;
	}
	public double getSc_qty_boi() {
		return sc_qty_boi;
	}
	public void setSc_qty_boi(double sc_qty_boi) {
		this.sc_qty_boi = sc_qty_boi;
	}
	public double getPd_qty_non_boi() {
		return pd_qty_non_boi;
	}
	public void setPd_qty_non_boi(double pd_qty_non_boi) {
		this.pd_qty_non_boi = pd_qty_non_boi;
	}
	public double getSc_qty_non_boi() {
		return sc_qty_non_boi;
	}
	public void setSc_qty_non_boi(double sc_qty_non_boi) {
		this.sc_qty_non_boi = sc_qty_non_boi;
	}
	public double getPd_qty_total() {
		return pd_qty_total;
	}
	public void setPd_qty_total(double pd_qty_total) {
		this.pd_qty_total = pd_qty_total;
	}
	public double getSc_qty_total() {
		return sc_qty_total;
	}
	public void setSc_qty_total(double sc_qty_total) {
		this.sc_qty_total = sc_qty_total;
	}
	public double getSum_pd_boi() {
		return sum_pd_boi;
	}
	public void setSum_pd_boi(double sum_pd_boi) {
		this.sum_pd_boi = sum_pd_boi;
	}
	public double getSum_sc_boi() {
		return sum_sc_boi;
	}
	public void setSum_sc_boi(double sum_sc_boi) {
		this.sum_sc_boi = sum_sc_boi;
	}
	public double getSum_pd_non_boi() {
		return sum_pd_non_boi;
	}
	public void setSum_pd_non_boi(double sum_pd_non_boi) {
		this.sum_pd_non_boi = sum_pd_non_boi;
	}
	public double getSum_sc_non_boi() {
		return sum_sc_non_boi;
	}
	public void setSum_sc_non_boi(double sum_sc_non_boi) {
		this.sum_sc_non_boi = sum_sc_non_boi;
	}
	public double getSum_pd_total() {
		return sum_pd_total;
	}
	public void setSum_pd_total(double sum_pd_total) {
		this.sum_pd_total = sum_pd_total;
	}
	public double getSum_sc_total() {
		return sum_sc_total;
	}
	public void setSum_sc_total(double sum_sc_total) {
		this.sum_sc_total = sum_sc_total;
	}
	public double getP_qty_boi() {
		return p_qty_boi;
	}
	public void setP_qty_boi(double p_qty_boi) {
		this.p_qty_boi = p_qty_boi;
	}
	public String getP_str_qty_boi() {
		return p_str_qty_boi;
	}
	public void setP_str_qty_boi(String p_str_qty_boi) {
		this.p_str_qty_boi = p_str_qty_boi;
	}
	public double getP_qty_non_boi() {
		return p_qty_non_boi;
	}
	public void setP_qty_non_boi(double p_qty_non_boi) {
		this.p_qty_non_boi = p_qty_non_boi;
	}
	public String getP_str_qty_non_boi() {
		return p_str_qty_non_boi;
	}
	public void setP_str_qty_non_boi(String p_str_qty_non_boi) {
		this.p_str_qty_non_boi = p_str_qty_non_boi;
	}
	public double getP_qty_total() {
		return p_qty_total;
	}
	public void setP_qty_total(double p_qty_total) {
		this.p_qty_total = p_qty_total;
	}
	public String getP_str_qty_total() {
		return p_str_qty_total;
	}
	public void setP_str_qty_total(String p_str_qty_total) {
		this.p_str_qty_total = p_str_qty_total;
	}
	public int getSc_type_num() {
		return sc_type_num;
	}
	public void setSc_type_num(int sc_type_num) {
		this.sc_type_num = sc_type_num;
	}
	public String getSc_big_type() {
		return sc_big_type;
	}
	public void setSc_big_type(String sc_big_type) {
		this.sc_big_type = sc_big_type;
	}
	public String getStr_qty_non_boi() {
		return str_qty_non_boi;
	}
	public void setStr_qty_non_boi(String str_qty_non_boi) {
		this.str_qty_non_boi = str_qty_non_boi;
	}
	public String getStr_qty_total() {
		return str_qty_total;
	}
	public void setStr_qty_total(String str_qty_total) {
		this.str_qty_total = str_qty_total;
	}
	private String imagesName;
    private String styletype;
    private String color_num;
    
    
	
	public String getColor_num() {
		return color_num;
	}
	public void setColor_num(String color_num) {
		this.color_num = color_num;
	}
	public String getStyletype() {
		return styletype;
	}
	public void setStyletype(String styletype) {
		this.styletype = styletype;
	}
	public String getImagesName() {
		return imagesName;
	}
	public void setImagesName(String imagesName) {
		this.imagesName = imagesName;
	}
	public double getQty_boi() {
		return qty_boi;
	}
	public void setQty_boi(double qty_boi) {
		this.qty_boi = qty_boi;
	}
	public double getQty_non_boi() {
		return qty_non_boi;
	}
	public void setQty_non_boi(double qty_non_boi) {
		this.qty_non_boi = qty_non_boi;
	}
	public double getQty_total() {
		return qty_total;
	}
	public void setQty_total(double qty_total) {
		this.qty_total = qty_total;
	}
	public int getScrap_code_id() {
		return scrap_code_id;
	}
	public void setScrap_code_id(int scrap_code_id) {
		this.scrap_code_id = scrap_code_id;
	}
	public String getScrap_code() {
		return scrap_code;
	}
	public void setScrap_code(String scrap_code) {
		this.scrap_code = scrap_code;
	}
	private String scrap_remark;
    private String create_date;
    private Date create_date_d;
    private String create_by;
    private String create_name;
    private String update_date;
    private Date update_date_d;
    private String update_by;
    private String update_name;
    
    private String confirm_date;
    private Date confirm_date_d;
    private String confirm_by;
    private String confirm_name;
    
    private String Approved_name1;
    private String Approved_name2;
    private String Approved_name3;
    
    private int row_number ;
    private String status_name;
    private String status_name2;
    private int status_id;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScrap_date() {
		return scrap_date;
	}
	public void setScrap_date(String scrap_date) {
		this.scrap_date = scrap_date;
	}
	public int getPd_group() {
		return pd_group;
	}
	public void setPd_group(int pd_group) {
		this.pd_group = pd_group;
	}
	public String getPd_group_name() {
		return pd_group_name;
	}
	public void setPd_group_name(String pd_group_name) {
		this.pd_group_name = pd_group_name;
	}
	public int getPd_process() {
		return pd_process;
	}
	public void setPd_process(int pd_process) {
		this.pd_process = pd_process;
	}
	public String getProcess_name() {
		return process_name;
	}
	public void setProcess_name(String process_name) {
		this.process_name = process_name;
	}
	public int getMat_type() {
		return mat_type;
	}
	public void setMat_type(int mat_type) {
		this.mat_type = mat_type;
	}
	public String getMattype_name() {
		return mattype_name;
	}
	public void setMattype_name(String mattype_name) {
		this.mattype_name = mattype_name;
	}
	public int getScrap_type() {
		return scrap_type;
	}
	public void setScrap_type(int scrap_type) {
		this.scrap_type = scrap_type;
	}
	public String getScraptype_name() {
		return scraptype_name;
	}
	public void setScraptype_name(String scraptype_name) {
		this.scraptype_name = scraptype_name;
	}
	public double getScrap_Quatity() {
		return scrap_Quatity;
	}
	public void setScrap_Quatity(double scrap_Quatity) {
		this.scrap_Quatity = scrap_Quatity;
	}
	public int getScrap_unit() {
		return scrap_unit;
	}
	public void setScrap_unit(int scrap_unit) {
		this.scrap_unit = scrap_unit;
	}
	public String getScp_unit_name() {
		return scp_unit_name;
	}
	public void setScp_unit_name(String scp_unit_name) {
		this.scp_unit_name = scp_unit_name;
	}
	public double getScrap_Weight() {
		return scrap_Weight;
	}
	public void setScrap_Weight(double scrap_Weight) {
		this.scrap_Weight = scrap_Weight;
	}
	public String getScrap_remark() {
		return scrap_remark;
	}
	public void setScrap_remark(String scrap_remark) {
		this.scrap_remark = scrap_remark;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getCreate_by() {
		return create_by;
	}
	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}
	public String getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}
	public String getUpdate_name() {
		return update_name;
	}
	public void setUpdate_name(String update_name) {
		this.update_name = update_name;
	}
	public String getApproved_name1() {
		return Approved_name1;
	}
	public void setApproved_name1(String approved_name1) {
		Approved_name1 = approved_name1;
	}
	public String getApproved_name2() {
		return Approved_name2;
	}
	public void setApproved_name2(String approved_name2) {
		Approved_name2 = approved_name2;
	}
	public String getApproved_name3() {
		return Approved_name3;
	}
	public void setApproved_name3(String approved_name3) {
		Approved_name3 = approved_name3;
	}
	public int getRow_number() {
		return row_number;
	}
	public void setRow_number(int row_number) {
		this.row_number = row_number;
	}
	public Date getScrap_date_d() {
		return scrap_date_d;
	}
	public void setScrap_date_d(Date scrap_date_d) {
		this.scrap_date_d = scrap_date_d;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getConfirm_date() {
		return confirm_date;
	}
	public void setConfirm_date(String confirm_date) {
		this.confirm_date = confirm_date;
	}
	public String getConfirm_by() {
		return confirm_by;
	}
	public void setConfirm_by(String confirm_by) {
		this.confirm_by = confirm_by;
	}
	public String getConfirm_name() {
		return confirm_name;
	}
	public void setConfirm_name(String confirm_name) {
		this.confirm_name = confirm_name;
	}
	public int getFactory_id() {
		return factory_id;
	}
	public void setFactory_id(int factory_id) {
		this.factory_id = factory_id;
	}
	public String getFac_name() {
		return fac_name;
	}
	public void setFac_name(String fac_name) {
		this.fac_name = fac_name;
	}
	public String getStatus_name2() {
		return status_name2;
	}
	public void setStatus_name2(String status_name2) {
		this.status_name2 = status_name2;
	}
	public Date getCreate_date_d() {
		return create_date_d;
	}
	public void setCreate_date_d(Date create_date_d) {
		this.create_date_d = create_date_d;
	}
	public Date getUpdate_date_d() {
		return update_date_d;
	}
	public void setUpdate_date_d(Date update_date_d) {
		this.update_date_d = update_date_d;
	}
	public Date getConfirm_date_d() {
		return confirm_date_d;
	}
	public void setConfirm_date_d(Date confirm_date_d) {
		this.confirm_date_d = confirm_date_d;
	}
	public double getConform_Weight() {
		return conform_Weight;
	}
	public void setConform_Weight(double conform_Weight) {
		this.conform_Weight = conform_Weight;
	}
	public String getScrap_typeboi() {
		return scrap_typeboi_name;
	}
	public void setScrap_typeboi(String scrap_typeboi) {
		this.scrap_typeboi_name = scrap_typeboi;
	}
	public String getScrap_typeboi_name() {
		return scrap_typeboi_name;
	}
	public void setScrap_typeboi_name(String scrap_typeboi_name) {
		this.scrap_typeboi_name = scrap_typeboi_name;
	}
	public int getScrap_typeboi_id() {
		return scrap_typeboi_id;
	}
	public void setScrap_typeboi_id(int scrap_typeboi_id) {
		this.scrap_typeboi_id = scrap_typeboi_id;
	}
	public String getStr_qty_boi() {
		return str_qty_boi;
	}
	public void setStr_qty_boi(String str_qty_boi) {
		this.str_qty_boi = str_qty_boi;
	}
	
    
    
}
