package view;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
import model.model_scrap_inform;

public class view_907_scap_check {

	private static DBConn objConnection = new DBConn();
    private Session session ;
	private String user_login = "";
	private String profile_login = "";
	private String scan_qr ;
	private boolean button_confirm = false;
	
	private double total_weight = 0;
	
	private ListModelList<model_scrap_inform> model_list_scrap;
	private model_scrap_inform select_scrap;
	
		
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
	
	public String getScan_qr() {
		return scan_qr;
	}

	public void setScan_qr(String scan_qr) {
		this.scan_qr = scan_qr;
	}

	public boolean isButton_confirm() {
		return button_confirm;
	}

	public void setButton_confirm(boolean button_confirm) {
		this.button_confirm = button_confirm;
	}

	public double getTotal_weight() {
		return total_weight;
	}

	public void setTotal_weight(double total_weight) {
		this.total_weight = total_weight;
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
    }
	
	@Command
	@NotifyChange("*")
	public void select_scrap(){
		button_confirm = true;
	}
	
	@Command
	@NotifyChange("*")
	public void load_scrap()
	{		
		List<model_scrap_inform> model_list = new ArrayList<>();
		int row = 1;
		boolean c_q = false;
		total_weight = 0;
		if(!scan_qr.equals(""))
		{
			if(model_list_scrap != null){
				
				for (int i = 0; i < model_list_scrap.getSize(); i++) {  
				
				    if((model_list_scrap.get(i).getId()+"").equals(scan_qr)){
				    	c_q = true;
				    }
					
						model_scrap_inform model = new model_scrap_inform();  
					   
					    model.setRow_number(model_list_scrap.get(i).getRow_number());
		            	model.setId(model_list_scrap.get(i).getId()); 
		            	model.setScrap_date(model_list_scrap.get(i).getScrap_date());
		            	model.setScrap_date_d(model_list_scrap.get(i).getScrap_date_d());
		            	model.setFactory_id(model_list_scrap.get(i).getFactory_id());
		            	model.setFac_name(model_list_scrap.get(i).getFac_name());
		            	model.setPd_group(model_list_scrap.get(i).getPd_group());
		            	model.setPd_group_name(model_list_scrap.get(i).getPd_group_name());
		            	model.setPd_process(model_list_scrap.get(i).getPd_process());
		            	model.setProcess_name(model_list_scrap.get(i).getProcess_name());
		            	model.setMat_type(model_list_scrap.get(i).getMat_type());
		            	model.setMattype_name(model_list_scrap.get(i).getMattype_name());
		            	model.setScrap_type(model_list_scrap.get(i).getScrap_type());
		            	model.setScraptype_name(model_list_scrap.get(i).getScraptype_name());
		            	model.setScrap_unit(model_list_scrap.get(i).getScrap_unit());
		            	model.setScp_unit_name(model_list_scrap.get(i).getScp_unit_name());
		            	model.setScrap_Quatity(model_list_scrap.get(i).getScrap_Quatity());
		            	model.setScrap_Weight(model_list_scrap.get(i).getScrap_Weight());
		            	model.setConform_Weight(model_list_scrap.get(i).getConform_Weight());
		            	model.setScrap_remark(model_list_scrap.get(i).getScrap_remark());
		            	model.setCreate_date(model_list_scrap.get(i).getCreate_date());
		            	model.setCreate_name(model_list_scrap.get(i).getCreate_name());
		            	model.setUpdate_date(model_list_scrap.get(i).getUpdate_date());
		            	model.setUpdate_name(model_list_scrap.get(i).getUpdate_name());
		            	model.setApproved_name1(model_list_scrap.get(i).getApproved_name1());
		            	model.setApproved_name2(model_list_scrap.get(i).getApproved_name2());
		            	model.setApproved_name3(model_list_scrap.get(i).getApproved_name3());
		            	model.setStatus_id(model_list_scrap.get(i).getStatus_id());
		            	model.setStatus_name(model_list_scrap.get(i).getStatus_name());
		            	model.setStatus_name2(model_list_scrap.get(i).getStatus_name2());
		            	
		            	model_list.add(model);   
		 			    row++;
		 			    
		 			   total_weight += model_list_scrap.get(i).getConform_Weight();
				    
				}
				
			}
			
			ResultSet rs_ = null;
	        SqlSelection sqlsel = new SqlSelection();
	        String StrSQL = "EXEC [908_SCRAP_CHECK] @START_DATE = '"+scan_qr+"'";	
	       
	        try {
	        	
	        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
	            while (rs_.next()) {
	            	
	            if(c_q == false)
	            {
	            	model_scrap_inform model = new model_scrap_inform();  
	            	
	            	model.setRow_number(row);
	            	model.setId(rs_.getInt("id")); 
	            	model.setScrap_date(rs_.getString("scrap_date"));
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
	            	
	            	total_weight += rs_.getDouble("confirm_weight");
	              }
	            }
	            
	            model_list_scrap = new ListModelList<model_scrap_inform>(model_list); 
	            ((ListModelList<model_scrap_inform>)model_list_scrap).setMultiple(true);
	            scan_qr = "";
	            button_confirm = false;
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	try {
					sqlsel.closeConnection();
				} catch (Exception e) {			
					e.printStackTrace();
				}
	        }	         
		}else{
			Clients.showNotification("WARNING_MESSAGE.!  <br/> Scan QrCode... <br/>",
		    Clients.NOTIFICATION_TYPE_WARNING, null, "middle_center", 2100);
		}
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
    
    @Command
	@NotifyChange("*")
	public void on_confirm()
	{
    	Connection conn = objConnection.getConnection();
		conn = objConnection.getConnection();
		
		try{			                 
			   int type_check = 0;
			
		    	for (Iterator<model_scrap_inform> k = model_list_scrap.iterator(); k.hasNext();) {
		    		model_scrap_inform i_count = k.next();	
		   			if(((ListModelList<model_scrap_inform>)model_list_scrap).isSelected(i_count)){
		 
						     java.sql.CallableStatement cstmt = conn.prepareCall("{call [909_SCRAP_CONFIRM](?,?,?,?)}");
								
							 cstmt.setInt(1, i_count.getId());
							 cstmt.setInt(2, 3);
							 cstmt.setString(3, user_login);
							 cstmt.setDouble(4, i_count.getConform_Weight());
							 cstmt.execute();	
		   				     
							 type_check++;
		   			}
				}
		    	
		    	model_list_scrap = null;
			
				if(type_check > 0){
					
					button_confirm = false;
					
					Clients.showNotification("SUCCESS_MESSAGE.!  <br/> Confirm COMPLETED. <br/>",
					Clients.NOTIFICATION_TYPE_INFO, null, "middle_center", 3100);	
				}else{
					Clients.showNotification("WARNING_MESSAGE.!  <br/> Not Confirm Printed row. <br/>",
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
    
}
