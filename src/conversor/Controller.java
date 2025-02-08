package conversor;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	
	@FXML
	private TextField inputValor;
	
	@FXML
	private ComboBox<String> unidadesEntrada;
	
	@FXML
	private ComboBox<String> unidadesSaida;
	
	@FXML
	private Label labelResultado;
	
	@FXML
	public void initialize() { 
		unidadesEntrada.getItems().setAll
			("CM", "M", "KM", "G", "KG", "T", "KM/H", "MPH", "M/S", "USD", "BRL", "GBP", "EUR");
		unidadesSaida.getItems().setAll
			("CM", "M", "KM", "G", "KG", "T", "KM/H", "MPH", "M/S", "USD", "BRL", "GBP", "EUR");
		
		unidadesEntrada.setValue("KM/H");
		unidadesSaida.setValue("MPH");
	}
	
	public void converter() {
		try {
			double valor = Double.parseDouble(inputValor.getText());
			String unidadeEntrada = unidadesEntrada.getValue();
			String unidadeSaida = unidadesSaida.getValue();
			
			double taxaConversao = getTaxaConversao(unidadeEntrada, unidadeSaida);
			if(taxaConversao != -1) {
				double resultado = valor * taxaConversao;
				labelResultado.setText(String.format("%.2f %s = %.2f %s", 
						valor, unidadeEntrada, resultado, unidadeSaida));
			} else {
				labelResultado.setText("Conversão Invalida!");
			}
		
		} catch (NumberFormatException e) {
			labelResultado.setText("Valor Invalido");
		}
	}

	private double getTaxaConversao(String unidadeEntrada, String unidadeSaida) {
		if ((unidadeEntrada.equals("CM") && unidadeSaida.equals("KM")) ||
			(unidadeEntrada.equals("G") && unidadeSaida.equals("KG"))  ||
			(unidadeEntrada.equals("KG") && unidadeSaida.equals("T"))  ||
			(unidadeEntrada.equals("M") && unidadeSaida.equals("KM"))) {
			return 0.001;
		} else if ((unidadeEntrada.equals("CM") && unidadeSaida.equals("M"))) {
			return 0.01;
		} else if ((unidadeEntrada.equals("G") && unidadeSaida.equals("T"))) {
			return 0.000001;
		} else if ((unidadeEntrada.equals("M") && unidadeSaida.equals("CM")) ||
			       (unidadeEntrada.equals("KG") && unidadeSaida.equals("G"))) {
			return 100;
		} else if ((unidadeEntrada.equals("KM") && unidadeSaida.equals("CM"))) {
			return 100000;
		} else if ((unidadeEntrada.equals("KM") && unidadeSaida.equals("M")) ||
			       (unidadeEntrada.equals("T") && unidadeSaida.equals("KG"))) {
			return 1000;
		} else if ((unidadeEntrada.equals("T") && unidadeSaida.equals("G"))) {
			return 1000000;
		} else if ((unidadeEntrada.equals("KM/H") && unidadeSaida.equals("MPH")) ||
			       (unidadeEntrada.equals("MPH") && unidadeSaida.equals("M/S"))) {
			return 0.6213;
		} else if ((unidadeEntrada.equals("MPH") && unidadeSaida.equals("KM/H"))) {
			return 1.609;
		} else if ((unidadeEntrada.equals("KM/H") && unidadeSaida.equals("M/S"))) {
			return 0.2777;
		} else if ((unidadeEntrada.equals("M/S") && unidadeSaida.equals("KM/H"))) {
			return 3.6;
		} else if ((unidadeEntrada.equals("M/S") && unidadeSaida.equals("MPH"))) {
			return 2.237;
		} else if(unidadeEntrada.equals("USD") && unidadeSaida.equals("BRL")) {
        	return 5.75;
        } else if(unidadeEntrada.equals("BRL") && unidadeSaida.equals("USD")) {
        	return 0.17;
        } else if(unidadeEntrada.equals("BRL") && unidadeSaida.equals("EUR")) {
        	return 0.16;
        } else if(unidadeEntrada.equals("EUR") && unidadeSaida.equals("BRL")) {
        	return 5.95;
        } else if(unidadeEntrada.equals("BRL") && unidadeSaida.equals("GBP")) {
        	return 0.14;
        } else if(unidadeEntrada.equals("GBP") && unidadeSaida.equals("BRL")) {
        	return 7.17;
        } else if(unidadeEntrada.equals("USD") && unidadeSaida.equals("GBP")) {
        	return 0.81;
        } else if(unidadeEntrada.equals("USD") && unidadeSaida.equals("EUR")) {
        	return 0.97;
        } else if(unidadeEntrada.equals("GBP") && unidadeSaida.equals("USD")) {
        	return 1.24;
        } else if(unidadeEntrada.equals("GBP") && unidadeSaida.equals("EUR")) {
        	return 1.20;
        } else if(unidadeEntrada.equals("EUR") && unidadeSaida.equals("USD")) {
        	return 1.03;
        } else if(unidadeEntrada.equals("EUR") && unidadeSaida.equals("GBP")) {
        	return 0.83;        	
        } else {
        	return -1;
        }
	}
	
	

}
