package com.example.vaadin;

import com.vaadin.Application;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window.Notification;
import com.vaadin.ui.themes.Reindeer;

import de.essendi.vaadin.ui.component.numberfield.NumberField;

/**
 * Main application class.
 */
public class VaadinApplication extends Application {

	@Override
	public void init() {
		final Window main = new Window("Métricas");
		//Label label = new Label("Hello Vaadin user");
		//mainWindow.addComponent(label);
		setMainWindow(main);
		
		final HorizontalLayout inicial = new HorizontalLayout();
		main.addComponent(inicial);
		inicial.setHeight(100,Sizeable.UNITS_PERCENTAGE);
		inicial.setWidth(100,Sizeable.UNITS_PERCENTAGE);
		//inicial.setStyleName(Reindeer.LAYOUT_BLACK);
		
		final VerticalLayout vertical = new VerticalLayout();
		inicial.addComponent(vertical);
		
		//Tamaño general de opciones
		vertical.setHeight(300,Sizeable.UNITS_PIXELS);
		vertical.setWidth(150,Sizeable.UNITS_PIXELS);
		//vertical.setStyleName(Reindeer.LAYOUT_WHITE);
		
		//Agrego primera tabla
		final Table table = new Table();

		/* Define the names and data types of columns.
		 * The "default value" parameter is meaningless here. */
		table.addContainerProperty("Reporte", String.class,  null);

		/* Add a few items in the table. */
		table.addItem(new Object[] {
		    "Facturación"}, new String("Facturacion"));
		table.addItem(new Object[] {
		    "Cobranza"}, new String("Cobranza"));
		table.addItem(new Object[] {
	    	"Recuperación"}, new String("Recuperacion"));
		
		table.setSelectable(true);
		table.setImmediate(true);
		table.setHeight("120");
		
		final Table table2 = new Table();

		/* Define the names and data types of columns.
		 * The "default value" parameter is meaningless here. */
		table2.addContainerProperty("Periodo", String.class,  null);

		/* Add a few items in the table. */
		table2.addItem(new Object[] {
		    "Mensual"}, new String("Facturacion"));
		table2.addItem(new Object[] {
		    "Anual"}, new String("Cobranza"));
		
		table2.setSelectable(true);
		table2.setImmediate(true);
		table2.setHeight("65");
		
		final String seleccion = "";
		
		/*table.addListener(new Property.ValueChangeListener() {
		    public void valueChange(ValueChangeEvent event) {
		        seleccion = (String) table.getValue();
		    }
		});*/
		
		vertical.addComponent(table);
		vertical.addComponent(table2);
		vertical.setComponentAlignment(table, Alignment.TOP_CENTER);
		vertical.setComponentAlignment(table2, Alignment.TOP_CENTER);
		
		final Button button = new Button("Graficar",
				  new Button.ClickListener() {
				    public void buttonClick(ClickEvent event) {
				        //event.getButton().setCaption("Done!");
				    	if(table.getValue() != null){
				    		main.showNotification(seleccion + (String) table.getValue(),Notification.TYPE_WARNING_MESSAGE);
				    	}else{
				    		main.showNotification("Se debe ingresar una opción",Notification.TYPE_WARNING_MESSAGE);
				    	}
				    }
				  });
		
		vertical.addComponent(button);
		vertical.setComponentAlignment(button, Alignment.MIDDLE_CENTER);
		
		HorizontalLayout hor_2 = new HorizontalLayout();
		inicial.addComponent(hor_2);
		
		Panel panel = new Panel("Gráficas");
		panel.setHeight("500");
		panel.setWidth("600");
		
		hor_2.addComponent(panel);
		hor_2.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
		
		//Textfield de números
		NumberField numField = new NumberField();
		numField.setDecimalAllowed(true);
		numField.setDecimalPrecision(2); 
		numField.setDecimalSeparator('.');
		numField.setErrorText("Formato incorrecto");
		numField.setNegativeAllowed(false); 
		
		vertical.addComponent(numField);
		
	}

}

