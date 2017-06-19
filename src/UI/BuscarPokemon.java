package UI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Contenedor.Contenedor;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BuscarPokemon {

	private JFrame frame;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JLabel lblNumero;

	private boolean listaActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarPokemon window = new BuscarPokemon();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	public JFrame getFrame() {
		return frame;
	}



	public void setFrame(JFrame frame) {
		this.frame = frame;
	}



	/**
	 * Create the application.
	 */
	public BuscarPokemon() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(202, 93, 86, 20);
		frame.getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.setBounds(127, 174, 161, 61);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setForeground(Color.BLUE);
		lblNumero.setBounds(110, 96, 49, 14);
		frame.getContentPane().add(lblNumero);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel).setBackground(Color.yellow);
		
		btnBuscar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// recoger el numero de la pantalla
				String s = txtBuscar.getText();
					// Comprobar que la matricula esta dentro del sistema
					if (listaActual) {
						// Una vez que sabemos que esta en el sistema recorremos
						// la lista y buscamos el pokemon con dicho numero
						for (int i = 0; i < Contenedor.listaPokemon.size(); i++) {
							Object vehiculoAux = null;
							if (Contenedor.listaPokemon.get(i).equals(vehiculoAux)) {
								// Container.vehiculoActivo;
								for(models.Pokemon valor : Contenedor.listaPokemon){
									if(valor.getListaPokemon().contains(vehiculoAux)){
										Contenedor.PokemonActivo = Contenedor.listaPokemon.indexOf(valor);
									}
								
								}
								
							}
							
						}
					} else {
						JOptionPane.showMessageDialog(null, "El Pokemon no esta guardado en el sistema");

					}

			} 
			

		
		});
	}

	

}
