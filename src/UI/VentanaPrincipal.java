package UI;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;

import Contenedor.Contenedor;
import models.Pokemon;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
public class VentanaPrincipal {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textNumero;
	private JTextField txtNivelEvolucion;
	private JTextField txtRegion;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnInsertar;
	private JButton btnBuscar;
	private JLabel lblPokedex;
	private JLabel lblNombre;
	private JLabel lblNumero;
	private JLabel lblNivelEvolucion;
	private JLabel lblRegion;
	private JLabel lblTipo;
	private JLabel lblComentarios;
	private JTextPane textComentarios;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(100, 100, 450, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAnterior = new JButton("<-");
		btnAnterior.setForeground(Color.BLACK);
		btnAnterior.setBounds(20, 25, 52, 40);
		frame.getContentPane().add(btnAnterior);
		
		JLabel lblPokedex = new JLabel("Pokedex");
		lblPokedex.setForeground(Color.BLUE);
		lblPokedex.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokedex.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPokedex.setBounds(157, 25, 109, 30);
		frame.getContentPane().add(lblPokedex);
		
		JButton btnSiguiente = new JButton("->");
		btnSiguiente.setBounds(352, 25, 52, 40);
		frame.getContentPane().add(btnSiguiente);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(0, 0, 255));
		lblNombre.setBounds(40, 101, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(83, 98, 86, 20);
		frame.getContentPane().add(textNombre);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setForeground(Color.BLUE);
		lblNumero.setBounds(40, 129, 46, 14);
		frame.getContentPane().add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setColumns(10);
		textNumero.setBounds(83, 126, 86, 20);
		frame.getContentPane().add(textNumero);
		
		JLabel lblNivelEvolucion = new JLabel("Nivel Evolucion:");
		lblNivelEvolucion.setForeground(Color.BLUE);
		lblNivelEvolucion.setBounds(10, 154, 76, 14);
		frame.getContentPane().add(lblNivelEvolucion);
		
		txtNivelEvolucion = new JTextField();
		txtNivelEvolucion.setBounds(83, 151, 86, 20);
		frame.getContentPane().add(txtNivelEvolucion);
		txtNivelEvolucion.setColumns(10);
		
		JLabel lblRegion = new JLabel("Region:");
		lblRegion.setForeground(Color.BLUE);
		lblRegion.setBounds(40, 179, 46, 14);
		frame.getContentPane().add(lblRegion);
		
		txtRegion = new JTextField();
		txtRegion.setBounds(83, 176, 86, 20);
		frame.getContentPane().add(txtRegion);
		txtRegion.setColumns(10);
		
		JButton btnInsertar = new JButton("Insertar Nuevo Pokemon");
		btnInsertar.setBounds(20, 248, 175, 43);
		frame.getContentPane().add(btnInsertar);
		
		JButton btnBuscar = new JButton("Buscar Pokemon");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BuscarPokemon b = new BuscarPokemon();
				b.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnBuscar.setBounds(231, 248, 175, 43);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(Color.BLUE);
		lblTipo.setBounds(242, 101, 24, 14);
		frame.getContentPane().add(lblTipo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fuego", "Planta", "Agua", "Fantasma", "Lucha", "Normal", "Roca"}));
		comboBox.setBounds(276, 98, 86, 17);
		frame.getContentPane().add(comboBox);
		
		JLabel lblComentarios = new JLabel("Comentarios:");
		lblComentarios.setForeground(Color.BLUE);
		lblComentarios.setBounds(202, 129, 64, 14);
		frame.getContentPane().add(lblComentarios);
		
		JTextPane txtComentarios = new JTextPane();
		txtComentarios.setBounds(276, 129, 120, 91);
		frame.getContentPane().add(txtComentarios);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 302);
		frame.getContentPane().add(panel).setBackground(Color.yellow);
		
		//metodos
		/**
		 * Metodo para insertar pokemon
		 */
		
		btnInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (btnInsertar.isEnabled()) {
					models.Pokemon aux = leerPokemon();
					Contenedor.listaPokemon.add(aux);
					ModoLeer();
					Contenedor.PokemonActivo = Contenedor.listaPokemon.size() - 1;
				}
			}
		});
		
	
	/**
	 * Metodo para mostrar proximo pokemon
	 */
	btnSiguiente.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {

			int SiguienteIndice = Contenedor.PokemonActivo + 1;
		}
	});

	/**
	 * Metodo para mostrar pokemon anterior
	 */
	btnAnterior.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int AnteriorIndice = Contenedor.PokemonActivo - 1;
		}
	});
	
	
	
	}
	/**
		 * Metodo para leer y guardar los datos Almacena los datos introducidos en
		 * los campos de la pantalla en variable que se utilizan para crear un nuevo
		 * vehiculo
		 * 
		 * @return
		 */
	public Pokemon leerPokemon(){
			String Nombre = textNombre.getText().toUpperCase();
			String Numero= textNumero.getText().toUpperCase();
			String NivelEvolucion = txtNivelEvolucion.getText().toUpperCase();
			String Region = txtRegion.getText().toUpperCase();
			String Tipo = (String) comboBox.getSelectedItem();
			String Comentarios = textComentarios.getText().toUpperCase();
			return new Pokemon(Nombre, Numero, NivelEvolucion, Region, Tipo, Comentarios);
		}

		public void ModoLeer() {
			textNombre.setEnabled(false);
			textNumero.setEnabled(false);
			txtNivelEvolucion.setEnabled(false);
			txtRegion.setEnabled(false);
			textComentarios.setEnabled(false);
		}
}
