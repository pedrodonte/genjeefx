package generar.ui;

import generar.modelo.Entidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class FormularioEntidad extends GridPane {

	private Entidad entidad;

	Label lblEntidad = new Label("Entidad:");
	Label lblDao = new Label("DAO:");
	Label lblValObj = new Label("VO:");
	Label lblCrudServ = new Label("EJB Crud Service:");
	Label lblManBean = new Label("JSF Managed Bean:");
	Label lblXhml = new Label("JSF XHTML:");

	Label cpoEntidad = new Label("NA");
	
	Label cpoDao = new Label("NA");
	Label cpoValObj = new Label("NA");
	Label cpoCrudServ = new Label("NA");
	Label cpoManBean = new Label("NA");

	CheckBox chkDao = new CheckBox();
	CheckBox chkValObj = new CheckBox();
	CheckBox chkCrudServ = new CheckBox();
	CheckBox chkManBean = new CheckBox();
	
	Button btnModificar = new Button("Aplicar");
	private IModificaEntidad iModificaEntidad;

	public FormularioEntidad() {
		this.setPadding(new Insets(20, 20, 20, 20));
		this.setHgap(7);
		this.setVgap(7);

		this.add(lblEntidad, 0, 0);
		this.add(cpoEntidad, 1, 0);

		this.add(lblDao, 0, 1);
		this.add(cpoDao, 1, 1);
		this.add(chkDao, 2, 1);

		this.add(lblValObj, 0, 2);
		this.add(cpoValObj, 1, 2);
		this.add(chkValObj, 2, 2);

		this.add(lblCrudServ, 0, 3);
		this.add(cpoCrudServ, 1, 3);
		this.add(chkCrudServ, 2, 3);

		this.add(lblManBean, 0, 4);
		this.add(cpoManBean, 1, 4);
		this.add(chkManBean, 2, 4);
		
		this.add(btnModificar, 0, 5);
		
		
		btnModificar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if (iModificaEntidad != null) {
					iModificaEntidad.modificar(getEntidad());
				}			
			}
		});
		
	}

	public Entidad getEntidad() {
		entidad.getControllerMB().setGenerar(chkManBean.isSelected());
		entidad.getCrudService().setGenerar(chkCrudServ.isSelected());
		entidad.getDao().setGenerar(chkDao.isSelected());
		entidad.getVo().setGenerar(chkValObj.isSelected());
		return entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
		cpoDao.setText(entidad.getDao().getNombre());
		
		cpoEntidad.setText(entidad.getNombre());
		cpoValObj.setText(entidad.getVo().getNombre());
		cpoManBean.setText(entidad.getControllerMB().getNombre());
		cpoCrudServ.setText(entidad.getCrudService().getNombre());
		
		chkDao.setSelected(entidad.getDao().isGenerar());
		chkValObj.setSelected(entidad.getVo().isGenerar());
		chkCrudServ.setSelected(entidad.getCrudService().isGenerar());
		chkManBean.setSelected(entidad.getControllerMB().isGenerar());
	}
	
	public IModificaEntidad getiModificaEntidad() {
		return iModificaEntidad;
	}

	public void setiModificaEntidad(IModificaEntidad iModificaEntidad) {
		this.iModificaEntidad = iModificaEntidad;
	}

}
