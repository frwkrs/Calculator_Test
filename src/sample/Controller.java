package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    @FXML
    private Text output;
    private String operator = "";
    private double number1 = 0;
    private boolean start = true;

    private Model model = new Model();

    @FXML
    private void processNumpad(ActionEvent actionEvent) {
        if (start) {
            output.setText("");
            start = false;
        }
       String value = ((Button)actionEvent.getSource()).getText();
       output.setText(output.getText() + value);

    }

    @FXML
    private void processOperator(ActionEvent actionEvent) {
        String value = ((Button)actionEvent.getSource()).getText();

        if(!"=".equals(value)) {
            if (!operator.isEmpty() && output.getText().equals("")) {
                output.setText("0");
                return; }

            operator = value;
            number1 = Double.parseDouble(output.getText());
            output.setText("");
        } else {
            if (operator.isEmpty())
                return;

            output.setText(String.valueOf(model.calculate(number1, Double.parseDouble(output.getText()) ,operator)));
            operator = "";
            start = true;
            //Calculation
        }
    }

    @FXML
    private void processAC(ActionEvent actionEvent) {
        output.setText("");
        number1 = 0;
        start = true;
        operator = "";
    }

    @FXML
    private void processChangeSign(ActionEvent actionEvent) {
        if (!output.getText().equals("")) {
            output.setText(String.valueOf(model.changeSign(Double.parseDouble(output.getText()))));
        } else {
            output.setText("0");
        }

    }

    @FXML
    private void processFactor(ActionEvent actionEvent) {
        if (!output.getText().equals("")) {
            output.setText(String.valueOf(model.factorize(Double.parseDouble(output.getText()))));
        } else {
            output.setText("0");
        }
    }

    @FXML
    private void processRoot(ActionEvent actionEvent) {
        if (!output.getText().equals("")) {
            output.setText(String.valueOf(model.sqrt(Double.parseDouble(output.getText()))));
        } else {
            output.setText("0");
        }
    }
}
