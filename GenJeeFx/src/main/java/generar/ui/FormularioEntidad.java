package generar.ui;

import generar.modelo.Entidad;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FormularioEntidad extends GridPane{
	
	private Entidad entidad;
	
	Label lblEntidad 	= new Label("Entidad:");
	Label lblDao 		= new Label("DAO:");
	Label lblValObj 	= new Label("VO:");
	Label lblCrudServ 	= new Label("EJB Crud Service:");
	Label lblManBean	= new Label("JSF Managed Bean:");
	
	Label cpoEntidad	= new Label();

	
	TextField cpoDao		= new TextField();
	TextField cpoValObj 	= new TextField();
	TextField cpoCrudServ 	= new TextField();
	TextField cpoManBean	= new TextField();
	
	
	public FormularioEntidad() {
		this.setPadding(new Insets(20, 20, 20, 20));
		this.setHgap(7);
		this.setVgap(7);

		

		this.add(lblEntidad, 0, 0);
		this.add(cpoEntidad, 1, 0);
		
		this.add(lblDao, 0, 1);
		this.add(cpoDao, 1, 1);
		
		this.add(lblValObj, 0, 2);
		this.add(cpoValObj, 1, 2);

		this.add(lblCrudServ, 0, 3);
		this.add(cpoCrudServ, 1, 3);
		
		this.add(lblManBean, 0, 4);
		this.add(cpoManBean, 1, 4);
		
	}

	public Entidad getEntidad() {
		entidad.getDao().setNombre(cpoDao.getText());
		entidad.setNombre(cpoEntidad.getText());
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
		cpoDao.setText(entidad.getDao().getNombre());
		cpoEntidad.setText(entidad.getNombre());
		cpoValObj.setText(entidad.getVo().getNombre());
	}


}
