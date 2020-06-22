package view;

import java.io.ByteArrayOutputStream;
import java.sql.ResultSet;
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
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import connect.SqlSelection;
import general.DateTime;
import model.model_factory;
import model.model_itemNg;
import model.model_scrap_inform;

public class view_906_scap_view {

    private Session session ;
	private String user_login = "";
	private String profile_login = "";
	private Date startDate;
	private Date endDate;
	private String startDate_string;
	private String endDate_string;
	private int factory_id = 0;
	private int pd_group_id = 0;
	
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
        endDate = c.getTime();
		c.set(Calendar.DAY_OF_MONTH, 1);				
		startDate = c.getTime();
		
        set_date();
        load_factory();
 
    }
	
	public void set_date(){		
		startDate_string = DateTime.set_DateString(startDate);
		endDate_string = DateTime.set_DateString(endDate);
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
	
	@Command
	@NotifyChange("*")
	public void change_factory(){
		factory_id = select_fac.getFac_id();
		load_itemGroup();
	}
	

	public void load_itemGroup()
	{		
		ResultSet rs_ = null;
        List<model_itemNg> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [SUSPD5001_PRD_GROUP] ";	
        
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
	
	@Command
	@NotifyChange("*")
	public void change_product_group(){
		pd_group_id = select_itemGroup.getId();
	}
	
	@Command
	@NotifyChange("*")
	public void load_scrap()
	{		
		//if(select_itemGroup != null)
		//{
			set_date();
			ResultSet rs_ = null;
	        List<model_scrap_inform> model_list = new ArrayList<>();
	        SqlSelection sqlsel = new SqlSelection();
	        
	        String StrSQL = "EXEC [907_SCRAP_VIEW_Q] @START_DATE = '"+startDate_string+"',"
        		    + "@END_DATE = '"+endDate_string+"',"
	        		+ "@product_group='"+pd_group_id+"',"
	        		+ "@factory_id='"+factory_id+"'";	        	        	        
	        try {
	        	int row = 1;
	        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
	            while (rs_.next()) {
	            	model_scrap_inform model = new model_scrap_inform();  
	            	
	            	model.setRow_number(row);
	            	model.setId(rs_.getInt("id")); 
	            	model.setScrap_date(rs_.getString("scrap_date_2"));
	            	model.setScrap_date_d(rs_.getDate("scrap_date"));
	            	model.setFactory_id(rs_.getInt("factory_id"));
	            	model.setFac_name(rs_.getString("fac_name"));
	            	model.setPd_group(rs_.getInt("pd_group"));
	            	model.setPd_group_name(rs_.getString("pd_group_name"));
	            	model.setPd_process(rs_.getInt("pd_process"));
	            	model.setProcess_name(rs_.getString("process_name"));
	            	model.setMat_type(rs_.getInt("mat_type"));
	            	model.setMattype_name(rs_.getString("mattype_name"));
	            	model.setScrap_type(rs_.getInt("scrap_type"));
	            	model.setScraptype_name(rs_.getString("scraptype_name"));
	            	model.setScrap_unit(rs_.getInt("scrap_unit"));
	            	model.setScp_unit_name(rs_.getString("scp_unit_name"));
	            	model.setScrap_Quatity(rs_.getDouble("scrap_Quatity"));
	            	model.setScrap_Weight(rs_.getDouble("scrap_Weight"));
	            	model.setConform_Weight(rs_.getDouble("confirm_weight"));
	            	model.setScrap_remark(rs_.getString("scrap_remark"));
	            	
	            	model.setCreate_date(rs_.getString("create_date"));
	            	model.setCreate_name(rs_.getString("create_name"));
	            	
	            	model.setUpdate_date(rs_.getString("update_date"));
	            	model.setUpdate_name(rs_.getString("update_name"));
	            	
	            	model.setConfirm_date(rs_.getString("confirm_date"));
	            	model.setConfirm_name(rs_.getString("confirm_name"));
	            	
	            	model.setApproved_name1(rs_.getString("Approved_name1"));
	            	model.setApproved_name2(rs_.getString("Approved_name2"));
	            	model.setApproved_name3(rs_.getString("Approved_name3"));
	            	
	            	model.setStatus_id(rs_.getInt("scrap_status"));
	            		       
	            	if(rs_.getInt("scrap_status") == 0){
	            		model.setStatus_name("/images/del.gif");
	            		model.setStatus_name2("ยกเลิก");
	            	}else if (rs_.getInt("scrap_status") == 1){
	            		model.setStatus_name2("รอส่ง");
	            		model.setStatus_name("/images/printer_empty.png");
	            	}else if (rs_.getInt("scrap_status") == 2){
	            		model.setStatus_name("/images/building_go.png");
	            		model.setStatus_name2("รอตรวจสอบ");
	            	}else if (rs_.getInt("scrap_status") == 3){
	            		model.setStatus_name("/images/main.gif");
	            		model.setStatus_name2("ตรวจสอบแล้ว");
	            	}
	            	
	            	model_list.add(model);   
	            	row++;
	            }
	            model_list_scrap = new ListModelList<model_scrap_inform>(model_list); 
	            
	            	                 
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
    public void exportListboxToExcel() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
         
        ExcelExporter exporter = new ExcelExporter();
        exporter.export(list_item, out);
         
        AMedia amedia = new AMedia("scrap_control.xlsx", "xls", "application/file", out.toByteArray());
        Filedownload.save(amedia);
        out.close();
    }
    
}
