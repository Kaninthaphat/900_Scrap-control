package view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.exporter.excel.ExcelExporter;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import connect.DBConn;
import connect.SqlSelection;
import general.DateTime;
import general.ExportExcel;
import model.model_comboitem;
import model.model_sc_type;
import model.model_itemNg;
import model.model_scrap_inform;

public class view_917_scrap_summary {

	private static DBConn objConnection = new DBConn();
    private Session session ;
	private String user_login = "";
	private String profile_login = "";
	private Date startDate;
	private Date endDate;
	private String startDate_string;
	private String endDate_string;
	private int sc_type_num = 0;
	
	public int getSc_type_num() {
		return sc_type_num;
	}

	public void setSc_type_num(int sc_type_num) {
		this.sc_type_num = sc_type_num;
	}

	private int pd_group_id = 0;
	private boolean checktype_boi = true;
	private boolean checktype_non_boi = false;
	private boolean button_confirm = false;
	private boolean view_update = true;
	


	public boolean isView_update() {
		return view_update;
	}

	public void setView_update(boolean view_update) {
		this.view_update = view_update;
	}

	private double total_weight = 0;
	private double scrap_sale_weight = 0;
	private String scrap_remark;
	private int sc_type_id = 0;
	private int sc_type_boi = 0;
	private Date scrap_date_d;
	private String scrap_date_s;
	
	
	
	public model_comboitem getSelect_scptype() {
		return select_scptype;
	}

	public void setSelect_scptype(model_comboitem select_scptype) {
		this.select_scptype = select_scptype;
	}

	public String getScrap_remark() {
		return scrap_remark;
	}

	public void setScrap_remark(String scrap_remark) {
		this.scrap_remark = scrap_remark;
	}

	public int getSc_type_id() {
		return sc_type_id;
	}

	public void setSc_type_id(int sc_type_id) {
		this.sc_type_id = sc_type_id;
	}

	public Date getScrap_date_d() {
		return scrap_date_d;
	}

	public void setScrap_date_d(Date scrap_date_d) {
		this.scrap_date_d = scrap_date_d;
	}

	public String getScrap_date_s() {
		return scrap_date_s;
	}

	public void setScrap_date_s(String scrap_date_s) {
		this.scrap_date_s = scrap_date_s;
	}

	private int scrap_typeboi = 0;
	
	public int getScrap_typeboi() {
		return scrap_typeboi;
	}

	public void setScrap_typeboi(int scrap_typeboi) {
		this.scrap_typeboi = scrap_typeboi;
	}

	public int getSc_type_boi() {
		return sc_type_boi;
	}

	public void setSc_type_boi(int sc_type_boi) {
		this.sc_type_boi = sc_type_boi;
	}

	private int id;
	

	public double getScrap_sale_weight() {
		return scrap_sale_weight;
	}

	public void setScrap_sale_weight(double scrap_sale_weight) {
		this.scrap_sale_weight = scrap_sale_weight;
	}

	public double getTotal_weight() {
		return total_weight;
	}

	public void setTotal_weight(double total_weight) {
		this.total_weight = total_weight;
	}

	public boolean isButton_confirm() {
		return button_confirm;
	}

	public void setButton_confirm(boolean button_confirm) {
		this.button_confirm = button_confirm;
	}

	public boolean isChecktype_boi() {
		return checktype_boi;
	}

	public void setChecktype_boi(boolean checktype_boi) {
		this.checktype_boi = checktype_boi;
	}

	public boolean isChecktype_non_boi() {
		return checktype_non_boi;
	}

	public void setChecktype_non_boi(boolean checktype_non_boi) {
		this.checktype_non_boi = checktype_non_boi;
	}

	private ListModelList<model_comboitem> model_list_scptype;
	private model_comboitem select_scptype;
	private String select_scptype_name;
	
	private ListModelList<model_comboitem> model_list_typeboi;
	private model_comboitem select_typeboi;
	private String select_typeboi_name;
	
	public ListModelList<model_comboitem> getModel_list_typeboi() {
		return model_list_typeboi;
	}

	public void setModel_list_typeboi(ListModelList<model_comboitem> model_list_typeboi) {
		this.model_list_typeboi = model_list_typeboi;
	}

	public model_comboitem getSelect_typeboi() {
		return select_typeboi;
	}

	public void setSelect_typeboi(model_comboitem select_typeboi) {
		this.select_typeboi = select_typeboi;
	}

	public String getSelect_typeboi_name() {
		return select_typeboi_name;
	}

	public void setSelect_typeboi_name(String select_typeboi_name) {
		this.select_typeboi_name = select_typeboi_name;
	}

	public ListModelList<model_comboitem> getModel_list_scptype() {
		return model_list_scptype;
	}

	public void setModel_list_scptype(ListModelList<model_comboitem> model_list_scptype) {
		this.model_list_scptype = model_list_scptype;
	}

	public String getSelect_scptype_name() {
		return select_scptype_name;
	}

	public void setSelect_scptype_name(String select_scptype_name) {
		this.select_scptype_name = select_scptype_name;
	}

	private ListModelList<model_scrap_inform> model_list_scrap;
	private model_scrap_inform select_scrap;
	
	private ListModelList<model_sc_type> model_list_sc_type;
	private model_sc_type select_sc_type;
	private String select_sc_type_name;
	
	private ListModelList<model_itemNg> model_list_itemGroup;
	private model_itemNg select_itemGroup;
	private String select_itemGroup_name;
	
	public String getUser_login() {
		return user_login;
	}

	public void setUser_login(String user_login) {
		this.user_login = user_login;
	}

	public String getProfile_login() {
		return profile_login;
	}

	public void setProfile_login(String profile_login) {
		this.profile_login = profile_login;
	}
	
	public ListModelList<model_scrap_inform> getModel_list_scrap() {
		return model_list_scrap;
	}

	public void setModel_list_scrap(ListModelList<model_scrap_inform> model_list_scrap) {
		this.model_list_scrap = model_list_scrap;
	}
	public model_scrap_inform getSelect_scrap() {
		return select_scrap;
	}

	public void setSelect_scrap(model_scrap_inform select_scrap) {
		this.select_scrap = select_scrap;
	}

	public ListModelList<model_itemNg> getModel_list_itemGroup() {
		return model_list_itemGroup;
	}

	public void setModel_list_itemGroup(ListModelList<model_itemNg> model_list_itemGroup) {
		this.model_list_itemGroup = model_list_itemGroup;
	}

	public model_itemNg getSelect_itemGroup() {
		return select_itemGroup;
	}

	public void setSelect_itemGroup(model_itemNg select_itemGroup) {
		this.select_itemGroup = select_itemGroup;
	}

	public String getSelect_itemGroup_name() {
		return select_itemGroup_name;
	}

	public void setSelect_itemGroup_name(String select_itemGroup_name) {
		this.select_itemGroup_name = select_itemGroup_name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartDate_string() {
		return startDate_string;
	}

	public void setStartDate_string(String startDate_string) {
		this.startDate_string = startDate_string;
	}

	public String getEndDate_string() {
		return endDate_string;
	}

	public void setEndDate_string(String endDate_string) {
		this.endDate_string = endDate_string;
	}

	public ListModelList<model_sc_type> getModel_list_sc_type() {
		return model_list_sc_type;
	}

	public void setModel_list_sc_type(ListModelList<model_sc_type> model_list_sc_type) {
		this.model_list_sc_type = model_list_sc_type;
	}

	public model_sc_type getSelect_sc_type() {
		return select_sc_type;
	}

	public void setSelect_sc_type(model_sc_type select_sc_type) {
		this.select_sc_type = select_sc_type;
	}

	public String getSelect_sc_type_name() {
		return select_sc_type_name;
	}

	public void setSelect_sc_type_name(String select_sc_type_name) {
		this.select_sc_type_name = select_sc_type_name;
	}

	public int getPd_group_id() {
		return pd_group_id;
	}

	public void setPd_group_id(int pd_group_id) {
		this.pd_group_id = pd_group_id;
	}

	
	@Wire
	private Listbox list_item;
	
	@Init
	public void init() {
		System.out.println("@Init");
		
		session = Sessions.getCurrent();
		  if (session.getAttribute("session_PersonCode") == null || session.getAttribute("session_PersonCode") == "") {						    
				user_login= "";
				profile_login = "";
		  }else{				
				user_login =  session.getAttribute("session_PersonCode").toString();
				profile_login =  session.getAttribute("session_PersonProfile").toString();				
	     }
	}
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
        System.out.println("@AfterCompose");                    
        
        Calendar c = Calendar.getInstance();	
        scrap_date_d = c.getTime();
        endDate = c.getTime();
		c.set(Calendar.DAY_OF_MONTH, 1);				
		startDate = c.getTime();
		
        set_date();
        load_sc_type();
        load_typeboi();
 
    }
	
	public static String formatSring(double stock) {
		  NumberFormat formatter = new DecimalFormat("#,##0.00");             
	      return formatter.format(stock);
	}
	
	public void set_date(){		
		scrap_date_s = DateTime.set_DateString(scrap_date_d);
		startDate_string = DateTime.set_DateString(startDate);
		endDate_string = DateTime.set_DateString(endDate);
	}
	
	public void default_data(){		
		id = 0;
		scrap_sale_weight= 0;
		scrap_remark = "";
	}
	
	public void load_sc_type()
	{		
		ResultSet rs_ = null;
        List<model_sc_type> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "SELECT sc_type_num,sc_type_name FROM dbo.SC_BIG_TYPE ";	
        System.out.println(StrSQL);
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
            while (rs_.next()) {
            	model_sc_type model = new model_sc_type();  
                model.setSc_type_num(rs_.getInt("sc_type_num")); 
            	model.setSc_type_name(rs_.getString("sc_type_name"));
            	model_list.add(model);            	
            }
       
            model_list_sc_type = new ListModelList<model_sc_type>(model_list);      
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				sqlsel.closeConnection();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
	
	
	
	public void load_typeboi()
	{		
		ResultSet rs_ = null;
        List<model_comboitem> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "SELECT * FROM dbo.SCRAP_TYPR_BOI ORDER BY boi_row_number";	
        
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
            while (rs_.next()) {
            	model_comboitem model = new model_comboitem();    
            	model.setC_Id(rs_.getInt("boi_id"));
            	model.setC_Value(rs_.getInt("boi_row_number"));
            	model.setC_Name(rs_.getString("boi_name"));   
            	model.setC_Desc(rs_.getString("boi_desc"));
            	model_list.add(model);            	
            }
            model_list_typeboi = new ListModelList<model_comboitem>(model_list);      
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				sqlsel.closeConnection();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
	
	@Command
	@NotifyChange("*")
	public void change_sc_type(){
		
		sc_type_num = select_sc_type.getSc_type_num();
		
	}
	
	@Command
    @NotifyChange("scrap_typeboi")
    public void onselect_typeboi(){
		
		sc_type_boi = select_typeboi.getC_Id();
    	
    }
    
    @Command
    @NotifyChange("sc_type_id")
    public void onselect_scraptype(){
    	
    	sc_type_id = select_scptype.getC_Id();
    }
	
	
	@Command
	@NotifyChange("*")
	public void load_scrap()
	{		
		//if(select_itemGroup != null)
		//{
			set_date();
			List<model_scrap_inform> model_list = new ArrayList<>();
			
			ResultSet rs_ = null;
	        SqlSelection sqlsel = new SqlSelection();
	        String StrSQL = "EXEC [907_SCRAP_VIEW_IN] "
		        		+ "@sc_big_type='"+sc_type_num+"'";	
				
			
			
			System.out.println(StrSQL);
			
			
	        try {
	        	int row = 1;
	        	rs_ = sqlsel.getReSultSQL(StrSQL);
	            while (rs_.next()) {
	            	model_scrap_inform model = new model_scrap_inform();  
	            	
	            	model.setRow_number(row);
	            	model.setSc_big_type(rs_.getString("sc_type_name"));
	            	
	            	model.setStr_qty_non_boi(formatSring(rs_.getDouble("S_NON_BOI")));
	            	if(rs_.getDouble("S_NON_BOI") <0 ){
	            		model.setColor_num("font-weight:bold;color:#cc0000;font-size:12px;text-align:right;");
	            	}else{
	            		model.setColor_num("font-weight:bold;color:#00000;font-size:12px;text-align:right;");
	            	}
	            	model.setP_str_qty_non_boi(formatSring(rs_.getDouble("P_NON_BOI")));
	            	if(rs_.getDouble("P_NON_BOI") <0 ){
	            		model.setColor_num("font-weight:bold;color:#cc0000;font-size:12px;text-align:right;");
	            	}else{
	            		model.setColor_num("font-weight:bold;color:#00000;font-size:12px;text-align:right;");
	            	}
	            	
	            	model.setStr_qty_boi(formatSring(rs_.getDouble("S_BOI")));
	            	if(rs_.getDouble("S_BOI") <0 ){
	            		model.setColor_num("font-weight:bold;color:#cc0000;font-size:12px;text-align:right;");
	            	}else{
	            		model.setColor_num("font-weight:bold;color:#00000;font-size:12px;text-align:right;");
	            	}
	            	model.setP_str_qty_boi(formatSring(rs_.getDouble("P_BOI")));
	            	if(rs_.getDouble("P_BOI") <0 ){
	            		model.setColor_num("font-weight:bold;color:#cc0000;font-size:12px;text-align:right;");
	            	}else{
	            		model.setColor_num("font-weight:bold;color:#00000;font-size:12px;text-align:right;");
	            	}
	            	
	            	model.setStr_qty_total(formatSring(rs_.getDouble("S_TOTAL")));
	            	if(rs_.getDouble("S_TOTAL") <0 ){
	            		model.setColor_num("font-weight:bold;color:#cc0000;font-size:12px;text-align:right;");
	            	}else{
	            		model.setColor_num("font-weight:bold;color:#00000;font-size:12px;text-align:right;");
	            	}
	            	model.setP_str_qty_total(formatSring(rs_.getDouble("P_TOTAL")));
	            	if(rs_.getDouble("P_TOTAL") <0 ){
	            		model.setColor_num("font-weight:bold;color:#cc0000;font-size:12px;text-align:right;");
	            	}else{
	            		model.setColor_num("font-weight:bold;color:#00000;font-size:12px;text-align:right;");
	            	}
	            	
	            	model.setScrap_typeboi_id(rs_.getInt("scrap_type_boi"));
	            	
	            	if(rs_.getInt("scrap_type_boi") == 1){
	            		model.setScrap_typeboi_name("NON BOI");
	            		model.setStyletype("font-weight:bold;color:#0099ff;font-size:12px;text-align:center;");
	            	}else{
	            		model.setScrap_typeboi_name("BOI");
	            		model.setStyletype("font-weight:bold;color:#cc0000;font-size:12px;text-align:center;");
	            	}
	            	
	            	
	            	model_list.add(model);   
	            	row++;
	            	
	            
		            	
		            	
	            }
	            
	            
	            
	            
	            model_list_scrap = new ListModelList<model_scrap_inform>(model_list);
	            load_typeboi();
	            view_update = true;
	            default_data();
	            	                 
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	try {
					sqlsel.closeConnection();
				} catch (Exception e) {			
					e.printStackTrace();
				}
	        }
        
		//}else{
			//Clients.showNotification("WARNING_MESSAGE.!  <br/> Select..Product Group. <br/>",
		    //Clients.NOTIFICATION_TYPE_WARNING, null, "middle_center", 2100);
		//}
	}
	
	
	@Command
	@NotifyChange("*")
	public void on_select_scrapform(){
		
		if(view_update = true){
			
			id = 0;
			scrap_sale_weight = 0;
			
			sc_type_num = 0;
			
			select_sc_type_name = "SELECT";
			select_scptype_name = "SELECT";
			
		}
		
	}
	
	@Command
	@NotifyChange("*")
	public void call_insert(){
		on_insert();
	}
	
	@Command
	@NotifyChange("*")
	public void call_update(){
		if(select_scrap != null){
			
			if(select_scrap.getStatus_id() > 0 ){
			    on_insert();
			
			}else{
				Clients.showNotification("WARNING_MESSAGE.!  <br/> 1.NOT SALE <br/>",
					    Clients.NOTIFICATION_TYPE_WARNING, null, "middle_center", 3100);
			}
		}else{
			Clients.showNotification("WARNING_MESSAGE.!  <br/> 2.NOT SALE <br/>",
				    Clients.NOTIFICATION_TYPE_WARNING, null, "middle_center", 3100);
		}
		
	}
	
	public void on_insert()
	{		
		Connection conn = objConnection.getConnection();
		conn = objConnection.getConnection();
		try{			                 
			    
			if(id == 0){
			    if(select_sc_type != null){sc_type_num = select_sc_type.getSc_type_num();}else{sc_type_num = 0;}
				if(select_typeboi != null){scrap_typeboi = select_typeboi.getC_Id();}else{scrap_typeboi = 0;}
			}
			
			    if(sc_type_num != 0 && scrap_sale_weight !=0){				    					
			    	
			    	
			    	java.sql.CallableStatement cstmt = conn.prepareCall("{call [909_SCRAP_CONFIRM_SALE_IN](?,?,?,?,?,?)}");
					
					cstmt.setInt(1, id);
					cstmt.setString(2, DateTime.set_DateString(scrap_date_d));
					cstmt.setInt(3, sc_type_boi);
					cstmt.setDouble(4, scrap_sale_weight);
					cstmt.setString(5, user_login);
					cstmt.setInt(6, sc_type_num);
					cstmt.execute();
					
					load_scrap();
					default_data();
					
					Clients.showNotification("SUCCESS_MESSAGE.!  <br/> SALE COMPLETED. <br/>",
					Clients.NOTIFICATION_TYPE_INFO, null, "middle_center", 3100);	
					
				}else{
					Clients.showNotification("WARNING_MESSAGE.!  <br/> *Factory, *Group Product, *Scrap Type,*Weight <br/>",
				    Clients.NOTIFICATION_TYPE_WARNING, null, "middle_center", 3100);
				}
				
		   	}catch(Exception e){
		   		e.printStackTrace();
		   	}finally {
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
	}
	
	
	
	
	
	@Command
    @NotifyChange("*")
    public void exportListboxToExcel() throws Exception {
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ExcelExporter exporter = new ExcelExporter();
        exporter.export(list_item, out);
         
        AMedia amedia = new AMedia("scrap_control.xls", "xls", "application/file", out.toByteArray());
        Filedownload.save(amedia);
        out.close();
    }
    
    @Command
	@NotifyChange("*")
	public void onCallExcel() {						
		if(model_list_scrap.size() > 0)
			{	
			try {
				PrintToXls();
			} catch (IOException e) {				
					e.printStackTrace();
			} 
		}                
	}
    
    private void PrintToXls() throws IOException{									
    			
		ExportExcel excel = new ExportExcel();
		excel.createSheet("Scrap_Control");
			
			excel.setColumnWidth(0, 2);
			excel.setColumnWidth(1, 5);
			excel.setColumnWidth(2, 5);
			excel.setColumnWidth(3, 10);
			excel.setColumnWidth(4, 4);
			excel.setColumnWidth(5, 4);	
		
			excel.setStyle("H", ExportExcel.CenterStyle, ExportExcel.FontHeaderStyle);				
			excel.setStyle("PL", ExportExcel.LeftStyle, ExportExcel.FontDetailStyle);		
			excel.setStyle("DL", ExportExcel.LeftStyle, ExportExcel.FontDetailStyle,"LR");
			excel.setStyle("LB", ExportExcel.RightStyle, ExportExcel.FontDetailStyle, "BTLR");				
			excel.setStyle("T", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle, "T");
			excel.setStyle("L", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle, "LR");
						
			excel.setCellValue(1, 0, "#", excel.getStyle("HEAD"));
			excel.setCellValue(1, 1, "Scrap Type", excel.getStyle("HEAD"));
			excel.setCellValue(1, 2, "Status", excel.getStyle("HEAD"));
			excel.setCellValue(1, 3, "BOI", excel.getStyle("HEAD"));
			excel.setCellValue(1, 4, "NON BOI", excel.getStyle("HEAD"));
			excel.setCellValue(1, 5, "TOTAL", excel.getStyle("HEAD"));
	
			int rowNum=2;			
	
			for(model_scrap_inform report : model_list_scrap){
				
				excel.setCellValue(rowNum, 0, report.getRow_number(), excel.getStyle("DC"));				
				excel.setCellValue(rowNum, 1, report.getSc_big_type(), excel.getStyle("DL"));		
				excel.setCellValue(rowNum, 2, report.getScrap_typeboi_name(), excel.getStyle("DL"));		
				excel.setCellValue(rowNum, 3, report.getStr_qty_boi(), excel.getStyle("DL"));
				excel.setCellValue(rowNum, 4, report.getStr_qty_non_boi(), excel.getStyle("DL"));
				excel.setCellValue(rowNum, 5, report.getStr_qty_total(), excel.getStyle("DL"));
						
				rowNum ++;
			}
			
			excel.setBlankRow(rowNum, 0, 5, excel.getStyle("LB"));
			 
			 String prefix = "Scrap_Control";
			 String fileName = prefix + ".xls";
			 ByteArrayOutputStream bos = new ByteArrayOutputStream();
			 excel.getHssfWorkbook().write(bos);
	         ByteArrayInputStream pis = new ByteArrayInputStream(bos.toByteArray());
	         AMedia a = new AMedia(fileName, "xls", "application/vnd.ms-excel;charset=UTF-8", pis);  
	         Filedownload.save(a);
		
	 }
    
}
