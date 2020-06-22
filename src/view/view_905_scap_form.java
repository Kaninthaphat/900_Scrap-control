package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.exporter.excel.ExcelExporter;
import org.zkoss.image.AImage;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.WebApps;
import org.zkoss.zk.ui.event.EventQueues;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zss.api.Exporter;
import org.zkoss.zss.api.Exporters;
import org.zkoss.zss.api.Importer;
import org.zkoss.zss.api.Importers;
import org.zkoss.zss.api.Range;
import org.zkoss.zss.api.Ranges;
import org.zkoss.zss.api.SheetOperationUtil;
import org.zkoss.zss.api.model.Book;
import org.zkoss.zss.ui.Spreadsheet;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import connect.DBConn;
import connect.SqlSelection;
import general.DateTime;
import general.ExportExcel;
import model.model_comboitem;
import model.model_factory;
import model.model_itemNg;
import model.model_scrap_inform;

public class view_905_scap_form {

	private static DBConn objConnection = new DBConn();
	private static String path_name = "";
    private Session session ;
	private String user_login = "";
	private String profile_login = "";
	
	private Date startDate;
	private Date endDate;
	private String startDate_string;
	private String endDate_string;
	
	private ListModelList<model_scrap_inform> model_list_scrap;
	private model_scrap_inform select_scrap;
	
	private ListModelList<model_factory> model_list_fac;
	private model_factory select_fac;
	private String select_fac_name;
	
	private ListModelList<model_factory> model_list_fac2;
	private model_factory select_fac2;
	private String select_fac_name2;
	
	private ListModelList<model_itemNg> model_list_itemGroup;
	private model_itemNg select_itemGroup;
	private String select_itemGroup_name;
	
	private ListModelList<model_itemNg> model_list_itemGroup2;
	private model_itemNg select_itemGroup2;
	private String select_itemGroup_name2;
	
	private ListModelList<model_comboitem> model_list_process;
	private model_comboitem select_process;
	private String select_process_name;
	
	private ListModelList<model_comboitem> model_list_mattype;
	private model_comboitem select_mattype;
	private String select_mattype_name;
	
	private ListModelList<model_comboitem> model_list_scptype;
	private model_comboitem select_scptype;
	private String select_scptype_name;
	
	private ListModelList<model_comboitem> model_list_unit;
	private model_comboitem select_unit;
	private String select_unit_name;
	
	
	
	private int id;
	private String scrap_date_s;
	private Date scrap_date_d;
	private double scrap_Quatity;
	private double scrap_Weight;
	private String scrap_remark;
	
	private int factory_id = 0;
	private int pd_group_id = 0;
	private int mat_type_id = 0;
	private int sc_type_id = 0;
	private int pd_process = 0;
	private int scrap_unit = 0;
	
	private boolean view_print = false;
	private boolean view_update = true;
	
	private int factory_id2 = 0;
	private int pd_group_id2 = 0;
	
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

	public ListModelList<model_comboitem> getModel_list_mattype() {
		return model_list_mattype;
	}

	public void setModel_list_mattype(ListModelList<model_comboitem> model_list_mattype) {
		this.model_list_mattype = model_list_mattype;
	}

	public model_comboitem getSelect_mattype() {
		return select_mattype;
	}

	public void setSelect_mattype(model_comboitem select_mattype) {
		this.select_mattype = select_mattype;
	}

	public String getSelect_mattype_name() {
		return select_mattype_name;
	}

	public void setSelect_mattype_name(String select_mattype_name) {
		this.select_mattype_name = select_mattype_name;
	}

	public ListModelList<model_comboitem> getModel_list_scptype() {
		return model_list_scptype;
	}

	public void setModel_list_scptype(ListModelList<model_comboitem> model_list_scptype) {
		this.model_list_scptype = model_list_scptype;
	}

	public model_comboitem getSelect_scptype() {
		return select_scptype;
	}

	public void setSelect_scptype(model_comboitem select_scptype) {
		this.select_scptype = select_scptype;
	}

	public String getSelect_scptype_name() {
		return select_scptype_name;
	}

	public void setSelect_scptype_name(String select_scptype_name) {
		this.select_scptype_name = select_scptype_name;
	}

	public ListModelList<model_comboitem> getModel_list_process() {
		return model_list_process;
	}

	public void setModel_list_process(ListModelList<model_comboitem> model_list_process) {
		this.model_list_process = model_list_process;
	}

	public model_comboitem getSelect_process() {
		return select_process;
	}

	public void setSelect_process(model_comboitem select_process) {
		this.select_process = select_process;
	}

	public String getSelect_process_name() {
		return select_process_name;
	}

	public ListModelList<model_comboitem> getModel_list_unit() {
		return model_list_unit;
	}

	public void setModel_list_unit(ListModelList<model_comboitem> model_list_unit) {
		this.model_list_unit = model_list_unit;
	}

	public model_comboitem getSelect_unit() {
		return select_unit;
	}

	public void setSelect_unit(model_comboitem select_unit) {
		this.select_unit = select_unit;
	}

	public String getSelect_unit_name() {
		return select_unit_name;
	}

	public void setSelect_unit_name(String select_unit_name) {
		this.select_unit_name = select_unit_name;
	}

	public void setSelect_process_name(String select_process_name) {
		this.select_process_name = select_process_name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScrap_date_s() {
		return scrap_date_s;
	}

	public void setScrap_date_s(String scrap_date_s) {
		this.scrap_date_s = scrap_date_s;
	}

	public Date getScrap_date_d() {
		return scrap_date_d;
	}

	public void setScrap_date_d(Date scrap_date_d) {
		this.scrap_date_d = scrap_date_d;
	}
	public int getPd_process() {
		return pd_process;
	}

	public void setPd_process(int pd_process) {
		this.pd_process = pd_process;
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

	public boolean isView_print() {
		return view_print;
	}

	public void setView_print(boolean view_print) {
		this.view_print = view_print;
	}

	public boolean isView_update() {
		return view_update;
	}

	public void setView_update(boolean view_update) {
		this.view_update = view_update;
	}

	public int getPd_group_id() {
		return pd_group_id;
	}

	public void setPd_group_id(int pd_group_id) {
		this.pd_group_id = pd_group_id;
	}

	public int getMat_type_id() {
		return mat_type_id;
	}

	public void setMat_type_id(int mat_type_id) {
		this.mat_type_id = mat_type_id;
	}

	public int getSc_type_id() {
		return sc_type_id;
	}

	public void setSc_type_id(int sc_type_id) {
		this.sc_type_id = sc_type_id;
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

	public static String getPath_name() {
		return path_name;
	}

	public static void setPath_name(String path_name) {
		view_905_scap_form.path_name = path_name;
	}

	public ListModelList<model_factory> getModel_list_fac2() {
		return model_list_fac2;
	}

	public void setModel_list_fac2(ListModelList<model_factory> model_list_fac2) {
		this.model_list_fac2 = model_list_fac2;
	}

	public model_factory getSelect_fac2() {
		return select_fac2;
	}

	public void setSelect_fac2(model_factory select_fac2) {
		this.select_fac2 = select_fac2;
	}

	public String getSelect_fac_name2() {
		return select_fac_name2;
	}

	public void setSelect_fac_name2(String select_fac_name2) {
		this.select_fac_name2 = select_fac_name2;
	}

	public ListModelList<model_itemNg> getModel_list_itemGroup2() {
		return model_list_itemGroup2;
	}

	public void setModel_list_itemGroup2(ListModelList<model_itemNg> model_list_itemGroup2) {
		this.model_list_itemGroup2 = model_list_itemGroup2;
	}

	public model_itemNg getSelect_itemGroup2() {
		return select_itemGroup2;
	}

	public void setSelect_itemGroup2(model_itemNg select_itemGroup2) {
		this.select_itemGroup2 = select_itemGroup2;
	}

	public String getSelect_itemGroup_name2() {
		return select_itemGroup_name2;
	}

	public void setSelect_itemGroup_name2(String select_itemGroup_name2) {
		this.select_itemGroup_name2 = select_itemGroup_name2;
	}

	public int getFactory_id2() {
		return factory_id2;
	}

	public void setFactory_id2(int factory_id2) {
		this.factory_id2 = factory_id2;
	}

	public int getPd_group_id2() {
		return pd_group_id2;
	}

	public void setPd_group_id2(int pd_group_id2) {
		this.pd_group_id2 = pd_group_id2;
	}

	@Wire
    private Spreadsheet Spreadsheet;
	
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
		startDate = c.getTime();
		
        set_date();
        load_factory();
        load_mattype();
        load_scaptype();
        load_unit();
        load_path("qrcode_server");
        
        load_factory2();
    }
	
	public void set_date(){		
		scrap_date_s = DateTime.set_DateString(scrap_date_d);
		startDate_string = DateTime.set_DateString(startDate);
		endDate_string = DateTime.set_DateString(endDate);
	}
	
	public void default_data(){		
		id = 0;
		scrap_Quatity = 0;
		scrap_Weight= 0;
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
	
	@Command
	@NotifyChange("*")
	public void change_factory(){
		
		factory_id = select_fac.getFac_id();
		
		load_itemGroup();
		load_process_Byfactory();
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
	
	public void load_itemGroup_ALL()
	{		
		ResultSet rs_ = null;
        List<model_itemNg> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [SUSPD5001_PRD_GROUP] ";	
        
        try {
        	int row = 1;
        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
            while (rs_.next()) {
            	            	
	            	model_itemNg model = new model_itemNg();  
	                model.setId(rs_.getInt("PRODUCT_GROUP_CODE")); 
	            	model.setItem_product_group(row+"."+rs_.getString("ITEM_PRODUCT_GROUP"));                       		                 	 
	            	model_list.add(model);  
	            	row++;
            	
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
		load_process();
	}
	
	public void load_process()
	{		
		select_process = null;
		select_process_name = "";
		
		ResultSet rs_ = null;
        List<model_comboitem> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [422_MAIN_PROCESS] @product_group='"+ select_itemGroup.getId() +"'";	
       
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);  
        	int row = 1;
            while (rs_.next()) {
            	model_comboitem model = new model_comboitem();    
            	model.setC_Id(rs_.getInt("id"));
            	model.setC_Name(row+"."+rs_.getString("process_name"));                       		                 	 
            	model_list.add(model);   
            	row++;
            }
            
            model_comboitem model = new model_comboitem();    
        	model.setC_Id(0);
        	model.setC_Name("N/A");                       		                 	 
        	model_list.add(model);    
        	
            model_list_process = new ListModelList<model_comboitem>(model_list);      
       
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
	
	public void load_process_Byfactory()
	{		
		select_process = null;
		select_process_name = "";
		
		ResultSet rs_ = null;
        List<model_comboitem> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [423_MAIN_PROCESS_ALL] @product_group='"+ select_fac.getFac_id() +"'";	
        
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);   
        	int row = 1;
            while (rs_.next()) {
            	model_comboitem model = new model_comboitem();    
            	model.setC_Id(rs_.getInt("id"));
            	model.setC_Name(row+"."+rs_.getString("process_name"));                       		                 	 
            	model_list.add(model); 
            	row++;
            }
            
            model_comboitem model = new model_comboitem();    
        	model.setC_Id(0);
        	model.setC_Name("N/A");                       		                 	 
        	model_list.add(model);    
        	
            model_list_process = new ListModelList<model_comboitem>(model_list);      
       
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
	
	public void load_mattype()
	{		
		ResultSet rs_ = null;
        List<model_comboitem> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "SELECT id,row_number,mattype_name,mattype_desc FROM dbo.B_SCRAP_MATTYPE ORDER BY row_number";	
        
        try {
        	int row = 1;
        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
            while (rs_.next()) {
            	model_comboitem model = new model_comboitem();    
            	model.setC_Id(rs_.getInt("id"));
            	model.setC_Value(rs_.getInt("row_number"));
            	model.setC_Name(row+"."+rs_.getString("mattype_name"));                       		                 	 
            	model_list.add(model);   
            	row++;
            }
            model_list_mattype = new ListModelList<model_comboitem>(model_list);      
       
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
        String StrSQL = "SELECT id,row_number,scraptype_name,scraptype_desc FROM dbo.B_SCRAP_TYPE ORDER BY row_number";	
        
        try {
        	int row = 1;
        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
            while (rs_.next()) {
            	model_comboitem model = new model_comboitem();    
            	model.setC_Id(rs_.getInt("id"));
            	model.setC_Value(rs_.getInt("row_number"));
            	model.setC_Name(row+"."+rs_.getString("scraptype_name"));                       		                 	 
            	model_list.add(model);  
            	row++;
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
	
	public void load_unit()
	{		
		ResultSet rs_ = null;
        List<model_comboitem> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "SELECT id,row_number,scp_unit_name,scp_unit_desc FROM dbo.B_SCRAP_UNIT ORDER BY row_number";	
        
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
            while (rs_.next()) {
            	model_comboitem model = new model_comboitem();    
            	model.setC_Id(rs_.getInt("id"));
            	model.setC_Value(rs_.getInt("row_number"));
            	model.setC_Name(rs_.getString("scp_unit_name"));   
            	model.setC_Desc(rs_.getString("scp_unit_desc"));
            	model_list.add(model);            	
            }
            model_list_unit = new ListModelList<model_comboitem>(model_list);      
       
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
	public void call_insert(){
		on_insert();
	}
	
	@Command
	@NotifyChange("*")
	public void call_update(){
		if(select_scrap != null){
			
			if(select_scrap.getStatus_id() == 1 || select_scrap.getStatus_id() == 2){
			    on_insert();
			
			}else{
				Clients.showNotification("WARNING_MESSAGE.!  <br/> 1.NOT UPDATE <br/>",
					    Clients.NOTIFICATION_TYPE_WARNING, null, "middle_center", 3100);
			}
		}else{
			Clients.showNotification("WARNING_MESSAGE.!  <br/> 2.NOT UPDATE <br/>",
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
			    if(select_mattype != null){mat_type_id = select_mattype.getC_Id();}else{mat_type_id = 0;}
			    if(select_scptype != null){sc_type_id = select_scptype.getC_Id();}else{sc_type_id = 0;}
			    if(select_process != null){pd_process = select_process.getC_Id();}else{pd_process = 0;}
				if(select_unit != null){scrap_unit = select_unit.getC_Id();}else{scrap_unit = 0;}
			}
			
			    if(factory_id != 0 && mat_type_id != 0 && sc_type_id != 0 ){				    					
			    	
			    	
			    	java.sql.CallableStatement cstmt = conn.prepareCall("{call [905_SCRAPFORM_INS](?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					
					cstmt.setInt(1, id);
					cstmt.setString(2, DateTime.set_DateString(scrap_date_d));
					cstmt.setInt(3, pd_group_id);
					cstmt.setInt(4, pd_process);
					cstmt.setInt(5, mat_type_id);
					cstmt.setInt(6, sc_type_id);
					cstmt.setDouble(7, scrap_Quatity);
					cstmt.setInt(8, scrap_unit);
					cstmt.setDouble(9, scrap_Weight);
					cstmt.setString(10, scrap_remark);
					cstmt.setString(11, user_login);
					cstmt.setString(12, user_login);
					cstmt.setString(13, "");
					cstmt.setString(14, "");
					cstmt.setString(15, "");
					cstmt.setInt(16, factory_id);
					cstmt.execute();
					
					load_scrap();
					default_data();
					
					Clients.showNotification("SUCCESS_MESSAGE.!  <br/> INSERT/UPDATE COMPLETED. <br/>",
					Clients.NOTIFICATION_TYPE_INFO, null, "middle_center", 3100);	
					
				}else{
					Clients.showNotification("WARNING_MESSAGE.!  <br/> *Factory, *Mat Type, *Scrap Type,*Weight <br/>",
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
	public void load_scrap()
	{				
			set_date();
			ResultSet rs_ = null;
	        List<model_scrap_inform> model_list = new ArrayList<>();
	        SqlSelection sqlsel = new SqlSelection();
	        String StrSQL = "EXEC [905_SCRAP_FORM_Q] @START_DATE = '"+startDate_string+"',"
        		    + "@END_DATE = '"+endDate_string+"',"
	        		+ "@product_group='"+pd_group_id2+"',"
	        		+ "@factory_id='"+factory_id2+"'";
	        
	        System.out.println(StrSQL);
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
	            }
	            model_list_scrap = new ListModelList<model_scrap_inform>(model_list); 
	            ((ListModelList<model_scrap_inform>)model_list_scrap).setMultiple(true);
	            
	            view_print = false;
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
	}
	
	@Command
	@NotifyChange("*")
	public void on_select_scrapform(){
		
		if(select_scrap != null){
			
			view_print = true;
			view_update = false;
							
			id = select_scrap.getId();
			scrap_date_d = select_scrap.getScrap_date_d();
			scrap_Quatity = select_scrap.getScrap_Quatity();
			scrap_Weight= select_scrap.getScrap_Weight();
			scrap_remark = select_scrap.getScrap_remark();
			
			factory_id = select_scrap.getFactory_id();
			pd_group_id = select_scrap.getPd_group();
			mat_type_id = select_scrap.getMat_type();
			sc_type_id = select_scrap.getScrap_type();
			pd_process = select_scrap.getPd_process();
			scrap_unit = select_scrap.getScrap_unit();
			
			select_fac_name = select_scrap.getFac_name();
			select_itemGroup_name = select_scrap.getPd_group_name();
			select_process_name = select_scrap.getProcess_name();
			select_mattype_name = select_scrap.getMattype_name();
			select_scptype_name = select_scrap.getScraptype_name();
			select_unit_name = select_scrap.getScp_unit_name();
			
			load_factory();
			load_itemGroup_ALL();
			load_mattype();
			load_scaptype();
			load_unit();
			
		}else{
			view_print = false;
			view_update = true;
			
			id = 0;
			scrap_Quatity = 0;
			scrap_Weight = 0;
			scrap_remark = "";
			
			factory_id = 0;
			pd_group_id = 0;
			mat_type_id = 0;
			sc_type_id = 0;
			pd_process = 0;
			scrap_unit = 0;
			
			select_fac_name = "SELECT";
			select_itemGroup_name = "N/A";
			select_process_name = "N/A";
			select_mattype_name = "SELECT";
			select_scptype_name = "SELECT";
			select_unit_name = "N/A";
		}
		
	}
	
	public void defulat_book(String filename) {
        Book book;
        final Importer importer = Importers.getImporter();
        try {
            book = importer.imports(WebApps.getCurrent().getResource("/excelfile/"+filename),filename);
        } catch (IOException exception) {
            throw new RuntimeException(exception.getMessage(), exception);
        }
        if (book != null) {
            book.setShareScope(EventQueues.APPLICATION);
            Spreadsheet.setBook(book);
            Spreadsheet.setUserName("ADMIN");        
       }
    }
	
	@Command
	@NotifyChange("*")
	public void load_excel()
	{						
		defulat_book("SUST-FM-SC-01.xls"); 
		Connection conn = objConnection.getConnection();
   		conn = objConnection.getConnection();
		try {    
        	
        	int i_row = 0 ;
        	int sum_row = 0;
        	for (Iterator<model_scrap_inform> k = model_list_scrap.iterator(); k.hasNext();) {
        		model_scrap_inform i_count = k.next();	
	   			if(((ListModelList<model_scrap_inform>)model_list_scrap).isSelected(i_count)){
	   				if(i_count.getStatus_id() == 1 || i_count.getStatus_id() == 2){
	   					sum_row++;
	   				}
	   			}
			}

			int row_1 = 1;
			int row_2 = 2;
			int row_7 = 7;
			int row_8 = 8;
			int row_10 = 10;
			int row_12 = 12;
			int row_15 = 15;
			int row_23 = 23;
			int row_21 = 21;
			int row_26 = 26;

        		for (Iterator<model_scrap_inform> k = model_list_scrap.iterator(); k.hasNext();) {
        			model_scrap_inform item_h = k.next();	
        			if(((ListModelList<model_scrap_inform>)model_list_scrap).isSelected(item_h))
        			{
	        		   if(item_h.getStatus_id() == 1 || item_h.getStatus_id() == 2){
	        					
	        			 if(sum_row == 1 || sum_row == 2){
	        			   i_row++;
			               	
	        			   if(i_row % 2 == 0){
							row_1 = 30;
							row_2 = 31;
							row_7 = 36;
							row_8 = 37;
							row_10 = 39;
							row_12 = 41;
							row_15 = 44;
							row_23 = 52;
							row_21 = 50;
							row_26 = 55;
	                       }else{
	                    	 row_1 = 1;
	               			 row_2 = 2;
	               			 row_7 = 7;
	               			 row_8 = 8;
	               			 row_10 = 10;
	               			 row_12 = 12;
	               			 row_15 = 15;
	               			 row_23 = 23;
	               			 row_21 = 21;
	               			 row_26 = 26;
	                       }
	        			   
	        				if(item_h.getStatus_id() == 1)
	        				{
		        					java.sql.CallableStatement cstmt = conn.prepareCall("{call [906_SCRAPFORM_CANCEL](?,?,?)}");			               		
				               		cstmt.setInt(1, item_h.getId());
				               		cstmt.setInt(2, 2);
				               		cstmt.setString(3, user_login);
				               		cstmt.execute();
	        				}
			               		
			               		set_qrcode(item_h.getId()+"",row_2,10);
		        				
			               		Range range = Ranges.range(Spreadsheet.getSelectedSheet(),row_8,2);
			                    range.setCellEditText(item_h.getScrap_date());
			                    
			                    Range range2 = Ranges.range(Spreadsheet.getSelectedSheet(),row_10,2);
			                    range2.setCellEditText(item_h.getPd_group_name());
			                    
			                    Range range3 = Ranges.range(Spreadsheet.getSelectedSheet(),row_12,2);
			                    range3.setCellEditText(item_h.getProcess_name());
			                    
			                    Range range4 = Ranges.range(Spreadsheet.getSelectedSheet(),row_15,3);
			                    range4.setCellEditText(item_h.getMattype_name());
			                    
			                    Range range5 = Ranges.range(Spreadsheet.getSelectedSheet(),row_15,4);
			                    range5.setCellEditText(item_h.getScraptype_name());
			                    	                        
			                    Range range6 = Ranges.range(Spreadsheet.getSelectedSheet(),row_15,6);
			                    range6.setCellValue(item_h.getScrap_Quatity());
			                    
			                    Range range7 = Ranges.range(Spreadsheet.getSelectedSheet(),row_15,7);
			                    range7.setCellEditText(item_h.getScp_unit_name());
			                    
			                    Range range8 = Ranges.range(Spreadsheet.getSelectedSheet(),row_15,8);
			                    range8.setCellValue(item_h.getScrap_Weight());
			                    
			                    Range range9 = Ranges.range(Spreadsheet.getSelectedSheet(),row_15,9);
			                    range9.setCellEditText(item_h.getScrap_remark());
			                                          	                        
			                    Range range10 = Ranges.range(Spreadsheet.getSelectedSheet(),row_21,2);
			                    range10.setCellEditText(item_h.getUpdate_name());
			                    	                        
			                    Range range11 = Ranges.range(Spreadsheet.getSelectedSheet(),row_1,1);
			                    range11.setCellEditText("สำหรับเจ้าหน้าที่");
			                    
			                    Range range12 = Ranges.range(Spreadsheet.getSelectedSheet(),row_7,1);
			                    range12.setCellEditText("สำหรับฝ่ายผลิต");
			                    
			                    Range range13 = Ranges.range(Spreadsheet.getSelectedSheet(),row_26,2);
			                    range13.setCellEditText("*** หมายเหตุ จำกัดน้ำหนักต่อถุงไม่เกิน 15 Kgs.");
			                    
			                    Range range14 = Ranges.range(Spreadsheet.getSelectedSheet(),row_23,2);
			                    range14.setCellEditText(item_h.getScrap_date());
			                    
			                    Range range15 = Ranges.range(Spreadsheet.getSelectedSheet(),row_8,8);
			                    range15.setCellEditText(item_h.getFac_name());
			                    
			                    Range range16 = Ranges.range(Spreadsheet.getSelectedSheet(),row_7,10);
			                    range16.setCellEditText(item_h.getId()+"");
			                    
	        			     }else{
	        			    	 Clients.showNotification("WARNING_MESSAGE.!  <br/> Select 1-2 row. <br/>",
	        				     Clients.NOTIFICATION_TYPE_WARNING, null, "middle_center", 3100);
	        			     }
//			                    row_1 += 29;
//								row_2 += 29;
//								row_7 += 29;
//								row_8 += 29;
//								row_10 += 29;
//								row_12 += 29;
//								row_15 += 29;
//								row_23 += 29;
//								row_21 += 29;
//								row_26 += 29;
								
//			                    if(sum_row == 1){        		
//			    	        		export_pdf();	
//			    	        	}			            
//				                
//			                    if(i_row % 2 == 0){				                    			                    				                       
//			                    	export_pdf();	 
//				                }
			    	        				                    
		                }	        					        				
        			}
        		}
        		       	
	        	if(sum_row == 1 || sum_row == 2){
	        		export_pdf();
	        		load_scrap();
	        	}
        	
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
        		conn.close();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
		
	
	public void load_path(String hostname)
	{		
		ResultSet rs_ = null;
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "SELECT id,path_type,path_name,path_name_link "+
                        "FROM [dbo].[MAS_SYS_PATH] "+
                        "WHERE path_type = '"+hostname+"'";	
       
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);         	
            while (rs_.next()) {           	 
            	path_name = rs_.getString("path_name");
            }
            
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
	
	private void set_qrcode(String code,int row,int column) throws WriterException, IOException{
		String qrCodeText = code;
		
		String filePath = path_name+code+".png";
		int size = 120;
		String fileType = "png";
		File qrFile = new File(filePath);
		createQRImage(qrFile, qrCodeText, size, fileType);
		
		Range selection = Ranges.range(Spreadsheet.getSelectedSheet(), row, column);
        try{
            SheetOperationUtil.addPicture(selection,new AImage(WebApps.getCurrent().getResource("/qrcode/scrap/"+code+".png")));
        }catch(IOException e){
            System.out.println(e);
        }
	}
	
	@SuppressWarnings("unchecked")
	private static void createQRImage(File qrFile, String qrCodeText, int size,String fileType) throws WriterException, IOException {
		
		@SuppressWarnings("rawtypes")
		Hashtable hintMap = new Hashtable();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText,BarcodeFormat.QR_CODE, size, size, hintMap);
		
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth,BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}
	
    public void export_pdf() throws IOException {
    	Exporter exporterpdf = Exporters.getExporter("pdf");
    	Book book = Spreadsheet.getBook();
        File file = File.createTempFile(Long.toString(System.currentTimeMillis()),"temp");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            exporterpdf.export(book, file);
           
        }finally{
            if(fos!=null){
                fos.close();
            }
        }
        Filedownload.save(new AMedia(book.getBookName()+"_"+scrap_date_d.toString()+".pdf", "pdf", "excelfile/", file, true)); 
	}
    
    
    @Command
	@NotifyChange("*")
	public void on_cancel()
	{   	
    	Connection conn = objConnection.getConnection();
		conn = objConnection.getConnection();
		
		try{			                 
			   int type_check = 0;
			
		    	for (Iterator<model_scrap_inform> k = model_list_scrap.iterator(); k.hasNext();) {
		    		model_scrap_inform i_count = k.next();	
		   			if(((ListModelList<model_scrap_inform>)model_list_scrap).isSelected(i_count)){
		   				
		   				 if(i_count.getStatus_id() == 1 || i_count.getStatus_id() == 2){
						     java.sql.CallableStatement cstmt = conn.prepareCall("{call [906_SCRAPFORM_CANCEL](?,?,?)}");
								
							 cstmt.setInt(1, i_count.getId());
							 cstmt.setInt(2, 0);// 0=Cancel 1=Edit 2=Print
							 cstmt.setString(3, user_login);
							 cstmt.execute();	
		   				 }else{
		   					type_check ++;
		   				 }
		   			}
				}
		    	
		    	load_scrap();
				default_data();
				
				if(type_check == 0){
					Clients.showNotification("SUCCESS_MESSAGE.!  <br/> Cancel COMPLETED. <br/>",
					Clients.NOTIFICATION_TYPE_INFO, null, "middle_center", 3100);	
				}else{
					Clients.showNotification("WARNING_MESSAGE.!  <br/> Not Cancel Printed row. <br/>",
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
			excel.setColumnWidth(1, 3);
			excel.setColumnWidth(2, 4);
			excel.setColumnWidth(3, 4);
			excel.setColumnWidth(4, 4);
			excel.setColumnWidth(5, 4);	
			excel.setColumnWidth(6, 4);
			excel.setColumnWidth(7, 4);
			excel.setColumnWidth(8, 4);
			excel.setColumnWidth(9, 4);
			excel.setColumnWidth(10, 4);	
			excel.setColumnWidth(11, 4);
			excel.setColumnWidth(12, 4);
			excel.setColumnWidth(13, 4);
			excel.setColumnWidth(14, 4);
			excel.setColumnWidth(15, 4);
			excel.setColumnWidth(16, 4);
		
			excel.setStyle("H", ExportExcel.CenterStyle, ExportExcel.FontHeaderStyle);
			excel.setStyle("HD", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle);
			excel.setStyle("HEAD", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle, "BTLR");					
			excel.setStyle("PL", ExportExcel.LeftStyle, ExportExcel.FontDetailStyle);		
			excel.setStyle("DL", ExportExcel.LeftStyle, ExportExcel.FontDetailStyle,"LR");
			excel.setStyle("DC", ExportExcel.CenterStyle, ExportExcel.FontDetailStyle,"LR");
			excel.setStyle("LB", ExportExcel.RightStyle, ExportExcel.FontDetailStyle, "BTLR");				
			excel.setStyle("T", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle, "T");
			excel.setStyle("L", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle, "LR");
			excel.setStyle("TB", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle, "TB");
			excel.setStyle("TR", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle, "TR");
			excel.setStyle("TBR", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle, "TBR");
			excel.setStyle("TLR", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle, "TLR");			
			excel.setStyle("PLT", ExportExcel.LeftStyle, ExportExcel.FontDetailStyle,"LRT");
			excel.setStyle("PLR", ExportExcel.LeftStyle, ExportExcel.FontDetailStyle,"L");
			excel.setStyle("DR", ExportExcel.DoubleStyle2, ExportExcel.FontDetailStyle,"LR");
						
			excel.setCellValue(1, 0, "#", excel.getStyle("HEAD"));			
			excel.setCellValue(1, 1, "ID", excel.getStyle("HEAD"));
			excel.setCellValue(1, 2, "ScrapDate", excel.getStyle("HEAD"));
			excel.setCellValue(1, 3, "Factory", excel.getStyle("HEAD"));
			excel.setCellValue(1, 4, "ProductGroup", excel.getStyle("HEAD"));
			excel.setCellValue(1, 5, "Process", excel.getStyle("HEAD"));
			excel.setCellValue(1, 6, "Mat'l Type", excel.getStyle("HEAD"));
			excel.setCellValue(1, 7, "Scrap Type", excel.getStyle("HEAD"));
			excel.setCellValue(1, 8, "Remark", excel.getStyle("HEAD"));
			excel.setCellValue(1, 9, "Quatity", excel.getStyle("HEAD"));
			excel.setCellValue(1, 10, "Unit", excel.getStyle("HEAD"));
			excel.setCellValue(1, 11, "Weight(Kgs.)", excel.getStyle("HEAD"));
			excel.setCellValue(1, 12, "Status", excel.getStyle("HEAD"));	
			excel.setCellValue(1, 13, "CreateDate", excel.getStyle("HEAD"));	
			excel.setCellValue(1, 14, "CreateBy", excel.getStyle("HEAD"));	
			excel.setCellValue(1, 15, "LastUpdate", excel.getStyle("HEAD"));	
			excel.setCellValue(1, 16, "UpdateBy", excel.getStyle("HEAD"));	
	
			int rowNum=2;			
	
			for(model_scrap_inform report : model_list_scrap){
				
				excel.setCellValue(rowNum, 0, report.getRow_number(), excel.getStyle("DC"));
				excel.setCellValue(rowNum, 1, report.getId(), excel.getStyle("DL"));
				excel.setCellValue(rowNum, 2, report.getScrap_date(), excel.getStyle("DL"));				
				excel.setCellValue(rowNum, 3, report.getFac_name(), excel.getStyle("DL"));
				excel.setCellValue(rowNum, 4, report.getPd_group_name(), excel.getStyle("DR"));				
				excel.setCellValue(rowNum, 5, report.getProcess_name(), excel.getStyle("DR"));		
				excel.setCellValue(rowNum, 6, report.getMattype_name(), excel.getStyle("DR"));
				excel.setCellValue(rowNum, 7, report.getScraptype_name(), excel.getStyle("DR"));
				excel.setCellValue(rowNum, 8, report.getScrap_remark(), excel.getStyle("DR"));					
				excel.setCellValue(rowNum, 9, report.getScrap_Quatity(), excel.getStyle("DC"));	
				excel.setCellValue(rowNum, 10, report.getScp_unit_name(), excel.getStyle("DC"));	
				excel.setCellValue(rowNum, 11, report.getScrap_Weight(), excel.getStyle("DC"));	
				excel.setCellValue(rowNum, 12, report.getStatus_name2(), excel.getStyle("DC"));	
				excel.setCellValue(rowNum, 13, report.getCreate_date(), excel.getStyle("DC"));	
				excel.setCellValue(rowNum, 14, report.getCreate_name(), excel.getStyle("DC"));	
				excel.setCellValue(rowNum, 15, report.getUpdate_date(), excel.getStyle("DC"));	
				excel.setCellValue(rowNum, 16, report.getUpdate_name(), excel.getStyle("DC"));	
						
				rowNum ++;
			}
			
			excel.setBlankRow(rowNum, 0, 16, excel.getStyle("LB"));
			excel.setMergedRegion(rowNum,(short)0 ,rowNum ,(short)16);
			rowNum++;
			 
			 String prefix = "Scrap_Control";
			 String fileName = prefix + ".xls";
			 ByteArrayOutputStream bos = new ByteArrayOutputStream();
			 excel.getHssfWorkbook().write(bos);
	         ByteArrayInputStream pis = new ByteArrayInputStream(bos.toByteArray());
	         AMedia a = new AMedia(fileName, "xls", "application/vnd.ms-excel;charset=UTF-8", pis);  
	         Filedownload.save(a);
		
	 }
    
    
    @Command
    @NotifyChange("scrap_unit")
    public void onselect_unit(){
    	scrap_unit = select_unit.getC_Id();
    	
    }
    
    @Command
    @NotifyChange("pd_process")
    public void onselect_process(){
    	pd_process = select_process.getC_Id();
    }
    
    @Command
    @NotifyChange("mat_type_id")
    public void onselect_mattype(){
    	mat_type_id = select_mattype.getC_Id();
    	 
    }
    
    @Command
    @NotifyChange("sc_type_id")
    public void onselect_scraptype(){
    	sc_type_id = select_scptype.getC_Id();
    }
    
    public void load_factory2()
	{		
		ResultSet rs_ = null;
        List<model_factory> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "SELECT fac_id,fac_name,fac_desc FROM dbo.B_ASY_FACTRORY ";	
        
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
            while (rs_.next()) {
            	model_factory model = new model_factory();  
                model.setFac_id(rs_.getInt("fac_id")); 
            	model.setFac_name(rs_.getString("fac_name"));             
            	model.setFac_desc(rs_.getString("fac_desc"));
            	model_list.add(model);            	
            }
       
            model_list_fac2 = new ListModelList<model_factory>(model_list);      
       
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
	public void change_factory2(){
		
		factory_id2 = select_fac2.getFac_id();
		load_itemGroup2();
		
	}
    
    public void load_itemGroup2()
	{		
		ResultSet rs_ = null;
        List<model_itemNg> model_list = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [SUSPD5001_PRD_GROUP] ";	
        
        try {
        	int row = 1;
        	rs_ = sqlsel.getReSultSQL(StrSQL);      	
            while (rs_.next()) {
            	
            	if(rs_.getInt("FAC_ID") == factory_id2){
            		
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
        	
            model_list_itemGroup2 = new ListModelList<model_itemNg>(model_list);        
       
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
	public void change_product_group2(){
		pd_group_id2 = select_itemGroup2.getId();
	}
    
}
