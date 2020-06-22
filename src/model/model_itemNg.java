package model;

import java.util.Date;

public class model_itemNg {
    
	private int product_group_id;
	private String item_product_group;
	private String date_s;
	private String gg_taget_down;
	private String ng_persen;
	private String df_taget_down;
	private String df_persen;
	private String month_sub_name;
	private String week_name;
	private String yyyydet;
	private String ng_group;
	private String item_no;
	private String PartCode;
	
	private String defec_qty;
	private String row_number;
	private String color_text;
	private String Lot_Control_Code;
	private String Slip_number;
	
	private int id;
	private int process_id;
	private String Process_Name;
	private int process_code;
	private int mrp_process_id;
	private String mrp_process_name;
	
	private String Sub_order;
	private String Barcode_number;
	private String Ng_user;
	private String Defec_Date;
	private Date Defec_Date_d;
	private int In_QTY;
	private int out_qty;
	private int ng_qty;
	private int df_qty;
	private String dif_per;
	
	private String Defec_Time;
	private String Defec_Time2;
	private String str_job;
	
	private String po;
	
	private String style_name;
	
	private double ng_per;
	private double ng_q;
	private double in_q;
	
	private String mat_code;
	private double budomari;
	private double mat_qty;
	private double mat_price;
	
	private double mat_cost;
	private double std_cost;
	private double actual_cost;
	private double ng_cost;
	private double defect_cost;
	
	private double wip_amount;
	private double cap_amount;
	private double over_cap;
	
	private double sum_ng;
	private double sum_defect;
	
	private double avg_cyclerime;
	private double mc;
	private double sec_month;
	private double cap_month;
	private double cap_day;
	private double target_day;
	
	private String ng_overTg;
	private String df_overTg;
	
	private String LastUpdate;
	private String LastUpdateByCode;
	private String LastUpdateByName;
	
	private String server_name;
	private int server_id;
	
	private int S_count;
	
	private double ngpsc_cost ;
	private double percap_day;
	private double percap_month;
	
	private String boi_detail;
	private String style_type ;
	private String new_process;
	private String Defec_Group;
	
	public String getStr_job() {
		return str_job;
	}
	public void setStr_job(String str_job) {
		this.str_job = str_job;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getItem_product_group() {
		return item_product_group;
	}
	public void setItem_product_group(String item_product_group) {
		this.item_product_group = item_product_group;
	}
	public String getDate_s() {
		return date_s;
	}
	public void setDate_s(String date_s) {
		this.date_s = date_s;
	}
	public String getGg_taget_down() {
		return gg_taget_down;
	}
	public void setGg_taget_down(String gg_taget_down) {
		this.gg_taget_down = gg_taget_down;
	}
	public String getNg_persen() {
		return ng_persen;
	}
	public void setNg_persen(String ng_persen) {
		this.ng_persen = ng_persen;
	}
	public String getMonth_sub_name() {
		return month_sub_name;
	}
	public void setMonth_sub_name(String month_sub_name) {
		this.month_sub_name = month_sub_name;
	}
	public String getWeek_name() {
		return week_name;
	}
	public void setWeek_name(String week_name) {
		this.week_name = week_name;
	}
	public String getYyyydet() {
		return yyyydet;
	}
	public void setYyyydet(String yyyydet) {
		this.yyyydet = yyyydet;
	}
	public String getNg_group() {
		return ng_group;
	}
	public void setNg_group(String ng_group) {
		this.ng_group = ng_group;
	}
	public String getItem_no() {
		return item_no;
	}
	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}
	
	public int getNg_qty() {
		return ng_qty;
	}
	public void setNg_qty(int ng_qty) {
		this.ng_qty = ng_qty;
	}
	
	public String getColor_text() {
		return color_text;
	}
	public void setColor_text(String color_text) {
		this.color_text = color_text;
	}
	public String getDefec_qty() {
		return defec_qty;
	}
	public void setDefec_qty(String defec_qty) {
		this.defec_qty = defec_qty;
	}
	public String getLot_Control_Code() {
		return Lot_Control_Code;
	}
	public void setLot_Control_Code(String lot_Control_Code) {
		Lot_Control_Code = lot_Control_Code;
	}
	public String getSlip_number() {
		return Slip_number;
	}
	public void setSlip_number(String slip_number) {
		Slip_number = slip_number;
	}
	public String getProcess_Name() {
		return Process_Name;
	}
	public void setProcess_Name(String process_Name) {
		Process_Name = process_Name;
	}
	public String getSub_order() {
		return Sub_order;
	}
	public void setSub_order(String sub_order) {
		Sub_order = sub_order;
	}
	public String getBarcode_number() {
		return Barcode_number;
	}
	public void setBarcode_number(String barcode_number) {
		Barcode_number = barcode_number;
	}
	public String getNg_user() {
		return Ng_user;
	}
	public void setNg_user(String ng_user) {
		Ng_user = ng_user;
	}
	public String getDefec_Date() {
		return Defec_Date;
	}
	public void setDefec_Date(String defec_Date) {
		Defec_Date = defec_Date;
	}
	public int getIn_QTY() {
		return In_QTY;
	}
	public void setIn_QTY(int in_QTY) {
		In_QTY = in_QTY;
	}
	public String getRow_number() {
		return row_number;
	}
	public void setRow_number(String row_number) {
		this.row_number = row_number;
	}
	public String getDif_per() {
		return dif_per;
	}
	public void setDif_per(String dif_per) {
		this.dif_per = dif_per;
	}
	public int getOut_qty() {
		return out_qty;
	}
	public void setOut_qty(int out_qty) {
		this.out_qty = out_qty;
	}
	public String getDefec_Time() {
		return Defec_Time;
	}
	public void setDefec_Time(String defec_Time) {
		Defec_Time = defec_Time;
	}
	public String getPartCode() {
		return PartCode;
	}
	public void setPartCode(String partCode) {
		PartCode = partCode;
	}
	
	public String getStyle_name() {
		return style_name;
	}
	public void setStyle_name(String style_name) {
		this.style_name = style_name;
	}
	public double getNg_per() {
		return ng_per;
	}
	public void setNg_per(double ng_per) {
		this.ng_per = ng_per;
	}
	public double getNg_q() {
		return ng_q;
	}
	public void setNg_q(double ng_q) {
		this.ng_q = ng_q;
	}
	public double getIn_q() {
		return in_q;
	}
	public void setIn_q(double in_q) {
		this.in_q = in_q;
	}
	public String getMat_code() {
		return mat_code;
	}
	public void setMat_code(String mat_code) {
		this.mat_code = mat_code;
	}
	public double getBudomari() {
		return budomari;
	}
	public void setBudomari(double budomari) {
		this.budomari = budomari;
	}
	public double getMat_qty() {
		return mat_qty;
	}
	public void setMat_qty(double mat_qty) {
		this.mat_qty = mat_qty;
	}
	public double getMat_price() {
		return mat_price;
	}
	public void setMat_price(double mat_price) {
		this.mat_price = mat_price;
	}
	public double getMat_cost() {
		return mat_cost;
	}
	public void setMat_cost(double mat_cost) {
		this.mat_cost = mat_cost;
	}
	public double getStd_cost() {
		return std_cost;
	}
	public void setStd_cost(double std_cost) {
		this.std_cost = std_cost;
	}
	public double getActual_cost() {
		return actual_cost;
	}
	public void setActual_cost(double actual_cost) {
		this.actual_cost = actual_cost;
	}
	public double getNg_cost() {
		return ng_cost;
	}
	public void setNg_cost(double ng_cost) {
		this.ng_cost = ng_cost;
	}
	public double getDefect_cost() {
		return defect_cost;
	}
	public void setDefect_cost(double defect_cost) {
		this.defect_cost = defect_cost;
	}
	public int getS_count() {
		return S_count;
	}
	public void setS_count(int s_count) {
		S_count = s_count;
	}
	public String getLastUpdate() {
		return LastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		LastUpdate = lastUpdate;
	}
	public String getLastUpdateByCode() {
		return LastUpdateByCode;
	}
	public void setLastUpdateByCode(String lastUpdateByCode) {
		LastUpdateByCode = lastUpdateByCode;
	}
	public String getLastUpdateByName() {
		return LastUpdateByName;
	}
	public void setLastUpdateByName(String lastUpdateByName) {
		LastUpdateByName = lastUpdateByName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProcess_id() {
		return process_id;
	}
	public void setProcess_id(int process_id) {
		this.process_id = process_id;
	}
	
	public int getProcess_code() {
		return process_code;
	}
	public void setProcess_code(int process_code) {
		this.process_code = process_code;
	}
	public int getMrp_process_id() {
		return mrp_process_id;
	}
	public void setMrp_process_id(int mrp_process_id) {
		this.mrp_process_id = mrp_process_id;
	}
	public String getMrp_process_name() {
		return mrp_process_name;
	}
	public void setMrp_process_name(String mrp_process_name) {
		this.mrp_process_name = mrp_process_name;
	}
	public String getServer_name() {
		return server_name;
	}
	public void setServer_name(String server_name) {
		this.server_name = server_name;
	}
	public int getServer_id() {
		return server_id;
	}
	public void setServer_id(int server_id) {
		this.server_id = server_id;
	}
	public double getNgpsc_cost() {
		return ngpsc_cost;
	}
	public void setNgpsc_cost(double ngpsc_cost) {
		this.ngpsc_cost = ngpsc_cost;
	}
	public double getSum_ng() {
		return sum_ng;
	}
	public void setSum_ng(double sum_ng) {
		this.sum_ng = sum_ng;
	}
	public double getSum_defect() {
		return sum_defect;
	}
	public void setSum_defect(double sum_defect) {
		this.sum_defect = sum_defect;
	}
	public String getBoi_detail() {
		return boi_detail;
	}
	public void setBoi_detail(String boi_detail) {
		this.boi_detail = boi_detail;
	}
	public String getStyle_type() {
		return style_type;
	}
	public void setStyle_type(String style_type) {
		this.style_type = style_type;
	}
	public String getDefec_Time2() {
		return Defec_Time2;
	}
	public void setDefec_Time2(String defec_Time2) {
		Defec_Time2 = defec_Time2;
	}
	public int getDf_qty() {
		return df_qty;
	}
	public void setDf_qty(int df_qty) {
		this.df_qty = df_qty;
	}
	public String getDf_taget_down() {
		return df_taget_down;
	}
	public void setDf_taget_down(String df_taget_down) {
		this.df_taget_down = df_taget_down;
	}
	public String getDf_persen() {
		return df_persen;
	}
	public void setDf_persen(String df_persen) {
		this.df_persen = df_persen;
	}
	public String getNew_process() {
		return new_process;
	}
	public void setNew_process(String new_process) {
		this.new_process = new_process;
	}
	public double getWip_amount() {
		return wip_amount;
	}
	public void setWip_amount(double wip_amount) {
		this.wip_amount = wip_amount;
	}
	public double getCap_amount() {
		return cap_amount;
	}
	public void setCap_amount(double cap_amount) {
		this.cap_amount = cap_amount;
	}
	public double getOver_cap() {
		return over_cap;
	}
	public void setOver_cap(double over_cap) {
		this.over_cap = over_cap;
	}
	public double getAvg_cyclerime() {
		return avg_cyclerime;
	}
	public void setAvg_cyclerime(double avg_cyclerime) {
		this.avg_cyclerime = avg_cyclerime;
	}
	public double getMc() {
		return mc;
	}
	public void setMc(double mc) {
		this.mc = mc;
	}
	public double getSec_month() {
		return sec_month;
	}
	public void setSec_month(double sec_month) {
		this.sec_month = sec_month;
	}
	public double getCap_month() {
		return cap_month;
	}
	public void setCap_month(double cap_month) {
		this.cap_month = cap_month;
	}
	public double getCap_day() {
		return cap_day;
	}
	public void setCap_day(double cap_day) {
		this.cap_day = cap_day;
	}
	public double getPercap_day() {
		return percap_day;
	}
	public void setPercap_day(double percap_day) {
		this.percap_day = percap_day;
	}
	public double getPercap_month() {
		return percap_month;
	}
	public void setPercap_month(double percap_month) {
		this.percap_month = percap_month;
	}
	public Date getDefec_Date_d() {
		return Defec_Date_d;
	}
	public void setDefec_Date_d(Date defec_Date_d) {
		Defec_Date_d = defec_Date_d;
	}
	public int getProduct_group_id() {
		return product_group_id;
	}
	public void setProduct_group_id(int product_group_id) {
		this.product_group_id = product_group_id;
	}
	public String getDefec_Group() {
		return Defec_Group;
	}
	public void setDefec_Group(String defec_Group) {
		Defec_Group = defec_Group;
	}
	public String getNg_overTg() {
		return ng_overTg;
	}
	public void setNg_overTg(String ng_overTg) {
		this.ng_overTg = ng_overTg;
	}
	public String getDf_overTg() {
		return df_overTg;
	}
	public void setDf_overTg(String df_overTg) {
		this.df_overTg = df_overTg;
	}
	public double getTarget_day() {
		return target_day;
	}
	public void setTarget_day(double target_day) {
		this.target_day = target_day;
	}
	
}
