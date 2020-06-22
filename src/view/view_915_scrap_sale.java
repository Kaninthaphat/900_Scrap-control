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
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import connect.DBConn;
import connect.SqlSelection;
import general.DateTime;
import general.ExportExcel;
import model.model_comboitem;
import model.model_factory;
import model.model_itemNg;
import model.model_scrap_inform;

public class view_915_scrap_sale {

	private static DBConn objConnection = new DBConn();
    private Session session ;
	private String user_login = "";
	private String profile_login = "";
	private Date startDate;
	private Date endDate;
	private String startDate_string;
	private String endDate_string;
	private int factory_id = 0;
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
	
	private ListModelList<model_factory> model_list_fac;
	private model_factory select_fac;
	private String select_fac_name;
	
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
	
	public ListModelList<model_factory> getModel_list_fac() {
		return model_list_fac;
	}

	public void setModel_list_fac(ListModelList<model_factory> model_list_fac) {
		this.model_list_fac = model_list_fac;
	}

	public model_factory getSelect_fac() {
		return select_fac;
	}

	public void setSelect_fac(model_factory select_fac) {
		this.select_fac = select_fac;
	}

	public String getSelect_fac_name() {
		return select_fac_name;
	}

	public void setSelect_fac_name(String select_fac_name) {
		this.select_fac_name = select_fac_name;
	}

	public int getFactory_id() {
		return factory_id;
	}

	public void setFactory_id(int factory_id) {
		this.factory_id = factory_id;
	}

	public int getPd_group_id() {
		return pd_group_id;
	}

	public void setPd_group_id(int pd_group_id) {
		this.pd_group_id = pd_group_id;
	}

	@Wire
	Checkbox c_boi;
	
	@Wire
	Checkbox c_non_boi;
	
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
        load_factory();
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
	
	public void load_factory()
	{		
		ResultSet rs_ = null;
        List<model_factory> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "SELECT fac_id,fac_name,fac_desc FROM dbo.B_ASY_FACTRORY ";	
        System.out.println(StrSQL);
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
            while (rs_.next()) {
            	model_factory model = new model_factory();  
                model.setFac_id(rs_.getInt("fac_id")); 
            	model.setFac_name(rs_.getString("fac_name"));             
            	model.setFac_desc(rs_.getString("fac_desc"));
            	model_list.add(model);            	
            }
       
            model_list_fac = new ListModelList<model_factory>(model_list);      
       
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
	

	public void load_itemGroup()
	{		
		ResultSet rs_ = null;
        List<model_itemNg> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [SUSPD5002_PRD_GROUP] ";	
        
        try {
        	int row = 1;
        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
            while (rs_.next()) {
            	
            	if(rs_.getInt("FAC_ID") == factory_id){
            		
	            	model_itemNg model = new model_itemNg();  
	                model.setId(rs_.getInt("PRODUCT_GROUP_CODE")); 
	            	model.setItem_product_group(row+"."+rs_.getString("ITEM_PRODUCT_GROUP"));                       		                 	 
	            	model_list.add(model);  
	            	row++;
            	}
            }
            
            model_itemNg model = new model_itemNg();  
            model.setId(0); 
        	model.setItem_product_group("N/A");                       		                 	 
        	model_list.add(model);  
        	
            model_list_itemGroup = new ListModelList<model_itemNg>(model_list);        
       
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
	
	public void load_scaptype()
	{		
		ResultSet rs_ = null;
        List<model_comboitem> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "SELECT id,scrap_name,product_group_code FROM dbo.SCRAP_TYPE_MIX ORDER BY id";	
        
        try {
        	int row = 1;
        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
            while (rs_.next()) {
            	
            	if(rs_.getInt("product_group_code") == pd_group_id){
            		
	            	model_comboitem model = new model_comboitem();    
	            	model.setC_Id(rs_.getInt("id"));
	            	model.setC_Name(row+"."+rs_.getString("scrap_name"));                       		                 	 
	            	model_list.add(model);  
	            	row++;
            	
            	}
            }
            model_list_scptype = new ListModelList<model_comboitem>(model_list);      
       
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
	public void change_factory(){
		
		factory_id = select_fac.getFac_id();
		load_itemGroup();
		
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
	public void change_product_group(){
		pd_group_id = select_itemGroup.getId();
		load_scaptype();
	}
	
	@Command
	@NotifyChange("*")
	public void load_scrap()
	{		
		//if(select_itemGroup != null)
		//{
			set_date();
			List<model_scrap_inform> model_list = new ArrayList<>();
			
			String type_value = "";
			ResultSet rs_ = null;
	        SqlSelection sqlsel = new SqlSelection();
	        String StrSQL = "";
			
	        
			if(checktype_boi == true && checktype_non_boi == false){
				type_value = "BOI";
				StrSQL = "EXEC [907_SCRAP_VIEW_BOI] "
		        		+ "@product_group='"+pd_group_id+"',"
		        		+ "@factory_id='"+factory_id+"',"
		        		+ "@type='"+type_value+"'";	
				
			}else if(checktype_boi == false && checktype_non_boi == true){
				type_value = "NON_BOI";
	            StrSQL = "EXEC [907_SCRAP_VIEW_NON_BOI] "
	        		+ "@product_group='"+pd_group_id+"',"
	        		+ "@factory_id='"+factory_id+"',"
	        		+ "@type='"+type_value+"'";
	            
			}else{    
				type_value = "ALL";
				StrSQL = "EXEC [907_SCRAP_VIEW_B] "
		        		+ "@product_group='"+pd_group_id+"',"
		        		+ "@factory_id='"+factory_id+"',"
		        		+ "@type='"+type_value+"'";
				
			}
			
			System.out.println(StrSQL);
			
	        try {
	        	int row = 1;
	        	rs_ = sqlsel.getReSultSQL(StrSQL);
	            while (rs_.next()) {
	            	model_scrap_inform model = new model_scrap_inform();  
	            	
	            	model.setRow_number(row);
	            	model.setFactory_id(rs_.getInt("factory_id"));
	            	model.setFac_name(rs_.getString("fac_name"));
	            	model.setPd_group(rs_.getInt("pd_group"));
	            	model.setPd_group_name(rs_.getString("PRODUCT_GROUP_NAME"));
	            	model.setScraptype_name(rs_.getString("scrap_name"));
	            	model.setScrap_code(rs_.getString("scrap_code"));
	            	
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
			scrap_remark = "";
			
			factory_id = 0;
			pd_group_id = 0;
			sc_type_id = 0;
			
			select_fac_name = "SELECT";
			select_itemGroup_name = "SELECT";
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
			    if(select_fac != null){factory_id = select_fac.getFac_id();}else{factory_id = 0;}			 
			    if(select_itemGroup != null){pd_group_id = select_itemGroup.getId();}else{pd_group_id = 0;}	
			    if(select_scptype != null){sc_type_id = select_scptype.getC_Id();}else{sc_type_id = 0;}
				if(select_typeboi != null){scrap_typeboi = select_typeboi.getC_Id();}else{scrap_typeboi = 0;}
			}
			
			    if(factory_id != 0 && pd_group_id != 0 && sc_type_id != 0 && scrap_sale_weight !=0){				    					
			    	
			    	
			    	java.sql.CallableStatement cstmt = conn.prepareCall("{call [909_SCRAP_CONFIRM_SALE](?,?,?,?,?,?,?,?,?)}");
					
					cstmt.setInt(1, id);
					cstmt.setString(2, DateTime.set_DateString(scrap_date_d));
					cstmt.setInt(3, pd_group_id);
					cstmt.setInt(4, sc_type_id);
					cstmt.setInt(5, sc_type_boi);
					cstmt.setDouble(6, scrap_sale_weight);
					cstmt.setString(7, scrap_remark);
					cstmt.setString(8, user_login);
					cstmt.setInt(9, factory_id);
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
	@NotifyChange("checktype_boi")
	public void onchechtype_true() {
		checktype_boi = c_boi.isChecked();
	}
	
	@Command
	@NotifyChange("checktype_non_boi")
	public void onchechtype_false() {
		checktype_non_boi = c_non_boi.isChecked();
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
			excel.setColumnWidth(6, 4);
			excel.setColumnWidth(7, 4);
			excel.setColumnWidth(8, 4);
		
			excel.setStyle("H", ExportExcel.CenterStyle, ExportExcel.FontHeaderStyle);
			excel.setStyle("HD", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle);
			excel.setStyle("HEAD", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle, "BTLR");					
			excel.setStyle("PL", ExportExcel.LeftStyle, ExportExcel.FontDetailStyle);		
			excel.setStyle("DL", ExportExcel.LeftStyle, ExportExcel.FontDetailStyle,"LR");
			excel.setStyle("DC", ExportExcel.CenterStyle, ExportExcel.FontDetailStyle,"LR");
			excel.setStyle("LB", ExportExcel.RightStyle, ExportExcel.FontDetailStyle, "BTLR");				
			excel.setStyle("T", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle, "T");
			excel.setStyle("L", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle, "LR");
						
			excel.setCellValue(1, 0, "#", excel.getStyle("HEAD"));			
			excel.setCellValue(1, 1, "Factory", excel.getStyle("HEAD"));
			excel.setCellValue(1, 2, "Product Group", excel.getStyle("HEAD"));
			excel.setCellValue(1, 3, "Scrap Type", excel.getStyle("HEAD"));
			excel.setCellValue(1, 4, "Scrap Code", excel.getStyle("HEAD"));
			excel.setCellValue(1, 5, "Status", excel.getStyle("HEAD"));
			excel.setCellValue(1, 6, "BOI", excel.getStyle("HEAD"));
			excel.setCellValue(1, 7, "NON BOI", excel.getStyle("HEAD"));
			excel.setCellValue(1, 8, "TOTAL", excel.getStyle("HEAD"));
	
			int rowNum=2;			
	
			for(model_scrap_inform report : model_list_scrap){
				
				excel.setCellValue(rowNum, 0, report.getRow_number(), excel.getStyle("DC"));
				excel.setCellValue(rowNum, 1, report.getFac_name(), excel.getStyle("DL"));
				excel.setCellValue(rowNum, 2, report.getPd_group_name(), excel.getStyle("DL"));				
				excel.setCellValue(rowNum, 3, report.getScraptype_name(), excel.getStyle("DL"));
				excel.setCellValue(rowNum, 4, report.getScrap_code(), excel.getStyle("DL"));				
				excel.setCellValue(rowNum, 5, report.getScrap_typeboi_name(), excel.getStyle("DL"));		
				excel.setCellValue(rowNum, 6, report.getStr_qty_boi(), excel.getStyle("DL"));
				excel.setCellValue(rowNum, 7, report.getStr_qty_non_boi(), excel.getStyle("DL"));
				excel.setCellValue(rowNum, 8, report.getStr_qty_total(), excel.getStyle("DL"));
						
				rowNum ++;
			}
			
			excel.setBlankRow(rowNum, 0, 8, excel.getStyle("LB"));
			 
			 String prefix = "Scrap_Control";
			 String fileName = prefix + ".xls";
			 ByteArrayOutputStream bos = new ByteArrayOutputStream();
			 excel.getHssfWorkbook().write(bos);
	         ByteArrayInputStream pis = new ByteArrayInputStream(bos.toByteArray());
	         AMedia a = new AMedia(fileName, "xls", "application/vnd.ms-excel;charset=UTF-8", pis);  
	         Filedownload.save(a);
		
	 }
    
}
