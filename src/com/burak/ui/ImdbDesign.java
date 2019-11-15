package com.burak.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.burak.model.Director;
import com.burak.model.Movie;
import com.burak.model.Star;
import com.burak.model.Writer;
import com.burak.service.DirectorService;
import com.burak.service.DirectorServiceImpl;
import com.burak.service.MovieService;
import com.burak.service.MovieServiceImpl;
import com.burak.service.StarService;
import com.burak.service.StarServiceImpl;
import com.burak.service.WriterService;
import com.burak.service.WriterServiceImpl;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.List;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.TextField;
import javax.swing.JList;

public class ImdbDesign {

	private JFrame frame;
	private JTextField txtSearch;
	public static List listFilm;
	private TextField textDescription;
	private List listDirectors;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImdbDesign window = new ImdbDesign();
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
	public ImdbDesign() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	java.util.List<Movie> movies = null;
	private JLabel imageLabel;
	private JLabel lblAklama;

	private JLabel lblDirectors;
	private List listWriters;
	private JLabel yazar;
	private List listStars;
	private JLabel lblOyuncular;

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 623, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtSearch = new JTextField();
		txtSearch.setBounds(10, 24, 163, 20);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");

		MovieService movieService = new MovieServiceImpl();
		DirectorService directorService = new DirectorServiceImpl();
		WriterService writerService = new WriterServiceImpl();
		StarService starService=new StarServiceImpl();
		

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listFilm.removeAll();
				listDirectors.removeAll();
				listStars.removeAll();
				listWriters.removeAll();
				String word = txtSearch.getText();
				word = word.replaceAll(" ", "+");
				movies = movieService.findMovies(word);
				int i = 0;
				for (Movie m : movies) {
					listFilm.add(m.getName(), i);
					i++;
				}
				i = 0;
			}
		});
		btnSearch.setBounds(187, 23, 89, 23);
		frame.getContentPane().add(btnSearch);

		listFilm = new List();
		listFilm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listDirectors.removeAll();
				listWriters.removeAll();
				listStars.removeAll();
				int index = listFilm.getSelectedIndex();
				Movie movie = movies.get(index);
				BufferedImage img = null;
				try {
					img = ImageIO.read(new URL(movie.getImageUrl()));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ImageIcon icon = new ImageIcon(img);
				imageLabel.setIcon(icon);
				textDescription.setText("");
				textDescription.setText(movieService.getDescription(movie));

				java.util.List<Director> directors = directorService.getDirectors(movie);
				int j = 0;
				for (Director director : directors) {
					listDirectors.add(director.getName(), j);
					j++;
				}
				j = 0;
				//int k = 0;
				java.util.List<Writer> writers = writerService.getWriters(movie);
				for (Writer writer : writers) {
					listWriters.add(writer.getName(), j);
					j++;
				}
				j = 0;
				java.util.List<Star> stars=starService.getStars(movie);
				for (Star star : stars) {
					listStars.add(star.getName(), j);
					j++;
				}
			}

		});
		listFilm.setBounds(10, 68, 110, 138);
		frame.getContentPane().add(listFilm);

		JLabel lblNewLabel = new JLabel("Kelime");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Fimler");
		lblNewLabel_1.setBounds(10, 55, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		imageLabel = new JLabel("");
		imageLabel.setBounds(418, 33, 179, 224);
		frame.getContentPane().add(imageLabel);

		lblAklama = new JLabel("A\u00E7\u0131klama");
		lblAklama.setBounds(144, 55, 71, 14);
		frame.getContentPane().add(lblAklama);

		textDescription = new TextField();
		textDescription.setBounds(134, 68, 163, 138);
		frame.getContentPane().add(textDescription);

		listDirectors = new List();
		listDirectors.setBounds(10, 227, 110, 145);
		frame.getContentPane().add(listDirectors);

		lblDirectors = new JLabel("Y\u00F6netmen");
		lblDirectors.setBounds(10, 213, 78, 14);
		frame.getContentPane().add(lblDirectors);

		listWriters = new List();
		listWriters.setBounds(144, 227, 110, 145);
		frame.getContentPane().add(listWriters);

		yazar = new JLabel("Yazar");
		yazar.setBounds(144, 212, 78, 14);
		frame.getContentPane().add(yazar);
		
		listStars = new List();
		listStars.setBounds(283, 227, 110, 145);
		frame.getContentPane().add(listStars);
		
		lblOyuncular = new JLabel("Oyuncular");
		lblOyuncular.setBounds(284, 213, 109, 14);
		frame.getContentPane().add(lblOyuncular);

	}
}
