package application;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;

public class Main extends Application implements EventHandler<ActionEvent> 
{
	Button b0;
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	Button b6;
	Button b7;
	Button b8;
	Button b9;
	Button bClear;
	Button bPlus;
	Button bMinus;
	Button bMultiply;
	Button bDivide;
	Button bSqrt;
	Button bNegative;
	Button bDecimal;
	Button bEquals;
	Label mainLabel;
	double x = 0; //this is the first stored value used to calculate
	double y = 0; //this is the first stored value used to calculate
	double xDecimalCounter = 10.0; //allows decimal place to be tracked
	double yDecimalCounter = 10.0;
	double mainDecimalCounter = 10.0;//keeps track of decimal place of x and y so that it can be applied when operator applied.
	double labelOutput = 0; //output to label
	boolean xFilled = false;
	boolean yFilled = false;
	boolean xDecimalPresent = false;
	boolean yDecimalPresent = false;
	boolean plus = false;
	boolean minus = false;
	boolean multiply = false;
	boolean divide = false;
	boolean sqrt = false;
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try 
		{
			GridPane grid = new GridPane();
			Scene scene = new Scene(grid,200,250);
			grid.setHgap(10);
			grid.setVgap(10); 
			grid.setPadding(new Insets(10, 10, 10, 10));
		    grid.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID,
                    CornerRadii.EMPTY, new BorderWidths(5))));
			b0 = new Button("0");
			b0.setOnAction(this);
			b1 = new Button("1");
			b1.setOnAction(this);
			b2 = new Button("2");
			b2.setOnAction(this);
			b3 = new Button("3");
			b3.setOnAction(this);
			b4 = new Button("4");
			b4.setOnAction(this);
			b5 = new Button("5");
			b5.setOnAction(this);
			b6 = new Button("6");
			b6.setOnAction(this);
			b7 = new Button("7");
			b7.setOnAction(this);
			b8 = new Button("8");
			b8.setOnAction(this);
			b9 = new Button("9");
			b9.setOnAction(this);
			bEquals = new Button("=");
			bEquals.setOnAction(this);
			bClear = new Button("Cl");
			bClear.setOnAction(this);
			bPlus = new Button("+");
			bPlus.setOnAction(this);
			bMinus = new Button("-");
			bMinus.setOnAction(this);
			bDivide = new Button("/");
			bDivide.setOnAction(this);
			bMultiply = new Button("x");
			bMultiply.setOnAction(this);
			bNegative = new Button("-x");
			bNegative.setOnAction(this);
			bSqrt = new Button("\u221A");
			bSqrt.setOnAction(this);
			bDecimal = new Button(".");
			bDecimal.setOnAction(this);
			mainLabel = new Label("                  ");
			mainLabel.setFont(new Font("Arial", 24));
			mainLabel.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, new BorderWidths(4))));
			grid.setConstraints(bClear, 0, 1);
			grid.setConstraints(bNegative, 1, 1);
			grid.setConstraints(bSqrt, 2, 1);
			grid.setConstraints(bDivide, 3, 1);
			grid.setConstraints(b7, 0, 2);
			grid.setConstraints(b8, 1, 2);
			grid.setConstraints(b9, 2, 2);
			grid.setConstraints(bMultiply, 3, 2);
			grid.setConstraints(b4, 0, 3);
			grid.setConstraints(b5, 1, 3);
			grid.setConstraints(b6, 2, 3);
			grid.setConstraints(bMinus, 3, 3);
			grid.setConstraints(b1, 0, 4);
			grid.setConstraints(b2, 1, 4);
			grid.setConstraints(b3, 2, 4);
			grid.setConstraints(bPlus, 3, 4);;
			grid.setConstraints(b0, 0, 5);
			grid.setConstraints(bDecimal, 1, 5);
			grid.setConstraints(bEquals, 2, 5,2,1);
			grid.setConstraints(mainLabel,0,0, 4,1);
			grid.getChildren().addAll(bClear, bNegative, bSqrt, bDivide,b7,b8,b9,bMultiply,b4,b5,b6,bMinus,b0,bDecimal,bEquals,bPlus, mainLabel,b1,b2,b3);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Four Function Calculator");
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void buttonClick (double n)
	{
		if(xFilled == false)
		{
			if(xDecimalPresent == false)
			{
				if (labelOutput == 0.0 )
				{
					labelOutput = n;
				}
				else
				{
					labelOutput = (labelOutput * 10) + n;
				}
				int intOutput = (int)labelOutput;
				String intstringOutput = String.valueOf(intOutput);
				mainLabel.setText(intstringOutput);
			}
			else
			{
			
				labelOutput = (n / xDecimalCounter) + labelOutput;
				xDecimalCounter = xDecimalCounter * 10;
				mainDecimalCounter = mainDecimalCounter *10;
				String stringOutput = String.valueOf(labelOutput);
				mainLabel.setText(stringOutput);	
			}	
					
			}
			else
			{
				if(yDecimalPresent == false)
				{
					if (labelOutput == 0.0 )
					{
						labelOutput = n;
					}
					else
					{
						labelOutput = (labelOutput * 10) + n;
					}
					int intOutput = (int)labelOutput;
					String intstringOutput = String.valueOf(intOutput);
					mainLabel.setText(intstringOutput);
				}
				else
				{
					
					labelOutput = (n / yDecimalCounter) + labelOutput;
					yDecimalCounter = yDecimalCounter * 10;
					mainDecimalCounter = mainDecimalCounter *10;
					String stringOutput = String.valueOf(labelOutput);
					mainLabel.setText(stringOutput);	
				}	
			}
	}
	
	@Override
	public void handle(ActionEvent event) 
	{
		if(event.getSource() == b0)
		{
			this.buttonClick(0.0);
		}
		else if(event.getSource() == b1)
		{
			this.buttonClick(1.0);
		}	
		else if(event.getSource() == b2)
		{
			this.buttonClick(2.0);
		}
		else if(event.getSource() == b3)
		{
			this.buttonClick(3.0);
		}
		else if(event.getSource() == b4)
		{
			this.buttonClick(4.0);
		}
		else if(event.getSource() == b5)
		{
			this.buttonClick(5.0);
		}
		else if(event.getSource() == b6)
		{
			this.buttonClick(6.0);
		}
		else if(event.getSource() == b7)
		{
			this.buttonClick(7.0);
		}
		else if(event.getSource() == b8)
		{
			this.buttonClick(8.0);
		}
		else if(event.getSource() == b9)
		{
			this.buttonClick(9.0);
		}
		else if(event.getSource() == bEquals)
		{
			yFilled = true;
			y = labelOutput;
			{
				if(plus == true)
				{
					labelOutput = x + y;
					x = labelOutput;
				
				}
				else if(minus == true)
				{
					labelOutput = x - y;
					x = labelOutput;
				}
				else if(multiply == true)
				{
					labelOutput = x * y;
					x = labelOutput;
				}
				else if(divide == true)
				{
					try
					{
						if(y == 0)
						{
							throw new IllegalArgumentException("ERROR");
						}
						else
						{
							labelOutput = x / y;
							x = labelOutput;
						}
					}
					catch (IllegalArgumentException e)
					{
						mainLabel.setText(e.getMessage());
						return;
					}
				}
				else if (sqrt = true)
				{
					try
					{
						if(x == 0)
						{
							throw new IllegalArgumentException("ERROR");
						}
						else
						{
							labelOutput = Math.sqrt(x);
							x = labelOutput;
						}
					}
					catch (IllegalArgumentException e)
					{
						mainLabel.setText(e.getMessage());
						return;
					}
				}
			}
			
			{
				if(x % 1 != 0)
				{
					xDecimalPresent = true;
				}
				else
				{
					xDecimalPresent = false;
				}
			}
			y = 0;
			xDecimalCounter = mainDecimalCounter;
			yDecimalCounter = 10.0;
			yDecimalPresent = false;
			xFilled = false;
			yFilled = false;
			
			if(xDecimalPresent == false && yDecimalPresent == false)
			{
				int intOutput = (int)labelOutput;
				String intstringOutput = String.valueOf(intOutput);
				mainLabel.setText(intstringOutput);
			
			}
			else
			{
				String stringOutput = String.valueOf(labelOutput);
				mainLabel.setText(stringOutput);
				
			}
			
			bPlus.setDisable(false);
			bMinus.setDisable(false);
			bDivide.setDisable(false);
			bMultiply.setDisable(false);
			bSqrt.setDisable(false);
		}

		else if(event.getSource() == bPlus)
		{
			xFilled = true;
			plus = true;
			minus = false;
			divide = false;
			multiply = false;
			sqrt = false;
			bPlus.setDisable(true);
			bMinus.setDisable(true);
			bDivide.setDisable(true);
			bMultiply.setDisable(true);
			bSqrt.setDisable(true);
			x = labelOutput;
			labelOutput = 0;
		}
		else if(event.getSource() == bMinus)
		{
			xFilled = true;
			plus = false;
			minus = true;
			divide = false;
			multiply = false;
			sqrt = false;
			bPlus.setDisable(true);
			bMinus.setDisable(true);
			bDivide.setDisable(true);
			bMultiply.setDisable(true);
			bSqrt.setDisable(true);
			x = labelOutput;
			labelOutput = 0;
		}
		else if(event.getSource() == bMultiply)
		{
			xFilled = true;
			plus = false;
			minus = false;
			divide = false;
			multiply = true;
			sqrt = false;
			bPlus.setDisable(true);
			bMinus.setDisable(true);
			bDivide.setDisable(true);
			bMultiply.setDisable(true);
			bSqrt.setDisable(true);
			x = labelOutput;
			labelOutput = 0;
		}
		else if(event.getSource() == bDivide)
		{
			xFilled = true;
			plus = false;
			minus = false;
			divide = true;
			multiply = false;
			sqrt = false;
			bPlus.setDisable(true);
			bMinus.setDisable(true);
			bDivide.setDisable(true);
			bMultiply.setDisable(true);
			bSqrt.setDisable(true);
			x = labelOutput;
			labelOutput = 0;
		}
		else if(event.getSource() == bSqrt)
		{
			xFilled = true;
			yFilled = true;
			plus = false;
			minus = false;
			divide = false;
			multiply = false;
			sqrt = true;
			bPlus.setDisable(true);
			bMinus.setDisable(true);
			bDivide.setDisable(true);
			bMultiply.setDisable(true);
			bSqrt.setDisable(true);
			x = labelOutput;
			labelOutput = 0;
		}
		else if(event.getSource() == bDecimal)
		{
			if(xFilled == false)
			{
				xDecimalPresent = true;
			}
			else
			{
				yDecimalPresent = true;
			}
		}
		else if (event.getSource() == bClear)
		{
			labelOutput = 0;
			x = 0;
			y = 0;
			xDecimalCounter = 10.0;
			yDecimalCounter = 10.0;
			mainDecimalCounter = 10.0;
			xFilled = false;
			yFilled = false;
			plus = false;
			minus = false;
			divide = false;
			multiply = false;
			sqrt = false;
			xDecimalPresent = false;
			yDecimalPresent = false;
			bPlus.setDisable(false);
			bMinus.setDisable(false);
			bDivide.setDisable(false);
			bMultiply.setDisable(false);
			bSqrt.setDisable(false);
			String stringOutput = String.valueOf("                  ");
			mainLabel.setText(stringOutput);
			
		}
		else if(event.getSource() == bNegative)
		{
			if(xFilled == false)
			{
				if(xDecimalPresent == false)
				{
					labelOutput = labelOutput * -1;
					int intOutput = (int)labelOutput;
					String intstringOutput = String.valueOf(intOutput);
					mainLabel.setText(intstringOutput);
				}
				else
				{
					labelOutput = labelOutput * -1.0;
					String stringOutput = String.valueOf(labelOutput);
					mainLabel.setText(stringOutput);
				}
			}
			else
			{
				if(yDecimalPresent == false)
				{
					labelOutput = labelOutput * -1;
					int intOutput = (int)labelOutput;
					String intstringOutput = String.valueOf(intOutput);
					mainLabel.setText(intstringOutput);
				}
				else
				{
					labelOutput = labelOutput * -1.0;
					String stringOutput = String.valueOf(labelOutput);
					mainLabel.setText(stringOutput);
				}
			}
		}
		
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	
}





