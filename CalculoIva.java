import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font; 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;


public class CalculoIva extends JFrame implements ActionListener
{
	private JLabel mensaje;
	private JLabel mensaje2;
	private JLabel mensaje3;
	private JLabel mensaje4;
	private JButton boton;
	private JTextField caja;
	private JComboBox iva;
	public String selectiva;
	
	public CalculoIva()
	{
		super();
		configurarVentana();
		crearComponentes();
	}
	
	private void configurarVentana(){
		this.setTitle("Calculo IVA");
		this.setSize(305,260);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void crearComponentes() {
		mensaje = new JLabel();
		mensaje2 = new JLabel();
		mensaje3 = new JLabel();
		mensaje4 = new JLabel();
		
		Font fuente = new Font("Lucida Sans", 1, 14);
        mensaje.setFont(fuente); 
		mensaje.setText("CALCULAR IVA");
		mensaje.setBounds(80, 1, 260, 50);
		this.add(mensaje);
		mensaje.setForeground(Color.BLACK);
		
		mensaje2.setText("CANTIDAD:");
		mensaje2.setBounds(80, 30, 200, 50);
		this.add(mensaje2);
		mensaje2.setForeground(Color.BLUE);
		
		mensaje3.setText("$");
		mensaje3.setBounds(70, 70, 90, 30);
		this.add(mensaje3);
		mensaje3.setForeground(Color.BLACK);
		
		caja = new JTextField();
		caja.setBounds(80, 70, 90, 30);
		this.add(caja);
		
		mensaje4.setText("IVA:");
		mensaje4.setBounds(80, 105, 90, 30);
		this.add(mensaje4);
		mensaje4.setForeground(Color.BLUE);
				
		String[] ivaList = new String[] {"16","8"};
		JComboBox<String> iva = new JComboBox<>(ivaList);
		iva.setBounds(80, 135, 90, 30);
		iva.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				selectiva = iva.getItemAt(iva.getSelectedIndex());
				System.out.println("El valor de iva es: "+selectiva);
			}
			
		});
		this.add(iva);
		
		boton = new JButton();
		boton.setText("Calcular");
		boton.setBounds(80, 175, 90, 30);
		boton.addActionListener(this);
		boton.setForeground(Color.BLUE);
		this.add(boton);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		String numero1 = caja.getText();
		double cantidad1 = Double.parseDouble(numero1);
		if(selectiva==null) {
			JOptionPane.showMessageDialog(this,"ERROR, no ha seleccionado el IVA");	
		}
		else {
			double cantidad2 = Double.parseDouble(selectiva);
			double iva = (cantidad1 *(cantidad2/100))+ cantidad1;
			
			JOptionPane.showMessageDialog(this,"La cantidad con IVA es: "+iva);	
		}
		

	}
	
	public static void main(String[] args) {
		CalculoIva ventana = new CalculoIva();
		ventana.setVisible(true);
	}
}

