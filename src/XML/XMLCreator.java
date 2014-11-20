package XML;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XMLCreator {

	// Nous allons commencer notre arborescence en créant la racine XML
	// qui sera ici "personnes".
	static Element racine = new Element("playlists");

	// On crée un nouveau Document JDOM basé sur la racine que l'on vient de
	// créer
	static Document document;
	File fXmlDocument = new File(System.getProperty("user.home")
			+ "/Desktop/test.xml");

//	public void createPlaylist(String psPlaylistName,
//			ArrayList<Music> poPlaylist) {
//
//		
//		if (!fXmlDocument.exists()) {
//			try {
//				fXmlDocument.createNewFile();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			document = new Document(racine);
//		} else {
//			SAXBuilder sxb = new SAXBuilder();
//			try {
//				document = sxb.build(fXmlDocument);
//				racine = document.getRootElement();
//			} catch (JDOMException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		// On crée un nouvel Element etudiant et on l'ajoute
//		// en tant qu'Element de racine
//		Element oPlaylist = new Element("playlist");
//		racine.addContent(oPlaylist);
//
//		// On crée un nouvel Attribut classe et on l'ajoute à etudiant
//		// grâce à la méthode setAttribute
//		Attribute sPlaylistName = new Attribute("name", psPlaylistName);
//		oPlaylist.setAttribute(sPlaylistName);
//
//		for (Music oMusic : poPlaylist) {
//			Element music = new Element("music");
//			music.setText(oMusic.getMsPath());
//			oPlaylist.addContent(music);
//		}
//
//		// Les deux méthodes qui suivent seront définies plus loin dans
//		// l'article
//		affiche();
//		enregistre(fXmlDocument.getAbsolutePath());
//	}
//
//	// Ajouter ces deux méthodes à notre classe JDOM1
//	static void affiche() {
//		try {
//			// On utilise ici un affichage classique avec getPrettyFormat()
//			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
//			sortie.output(document, System.out);
//		} catch (java.io.IOException e) {
//		}
//	}
//
//	static void enregistre(String fichier) {
//		try {
//			// On utilise ici un affichage classique avec getPrettyFormat()
//			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
//			// Remarquez qu'il suffit simplement de créer une instance de
//			// FileOutputStream
//			// avec en argument le nom du fichier pour effectuer la
//			// sérialisation.
//			sortie.output(document, new FileOutputStream(fichier));
//		} catch (java.io.IOException e) {
//		}
//	}
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		XMLCreator oCreator = new XMLCreator();
//	}
//
//	public static ArrayList<Music> getPlaylistByName(String psName){
//		File fXmlDocument = new File(System.getProperty("user.home")
//				+ "\\Desktop\\test.xml");
//		System.err.println("FILE " + System.getProperty("user.home")
//				+ "\\Desktop\\test.xml");
//		if (fXmlDocument.exists()){
//			SAXBuilder sxb = new SAXBuilder();
//			try {
//				document = sxb.build(fXmlDocument);
//				racine = document.getRootElement();
//			} catch (JDOMException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			List listPlaylists = racine.getChildren("playlist");
//			Iterator i = listPlaylists.iterator();
//			while (i.hasNext()) {
//				Element currentPlaylist = (Element) i.next();
//				System.out.println(currentPlaylist.getAttribute("name").getValue());
//				if (currentPlaylist.getAttribute("name").getValue().equals(psName)){
//					List listItems = currentPlaylist.getChildren();
//					Iterator itItems = listItems.iterator();
//					while(itItems.hasNext()){
//						Element currentItem = (Element) itItems.next();
//						File fItem = new File(currentItem.getText());
//						oPlaylistResult.add(new Music(fItem.getName(), fItem.getAbsolutePath()));
//					}
//					return oPlaylistResult;
//				}
//			}
//		}
//		return null;
//	}
//	
//	
//	public static void deletePlaylist(String psPlaylistName) {
//		File fXmlDocument = new File(System.getProperty("user.home")
//				+ "/Bureau/test.xml");
//		if (fXmlDocument.exists()){
//			SAXBuilder sxb = new SAXBuilder();
//			try {
//				document = sxb.build(fXmlDocument);
//				racine = document.getRootElement();
//			} catch (JDOMException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			List listPlaylists = racine.getChildren("playlist");
//	
//			// On crée un Iterator sur notre liste
//			Iterator i = listPlaylists.iterator();
//			while (i.hasNext()) {
//				// On recrée l'Element courant à chaque tour de boucle afin de
//				// pouvoir utiliser les méthodes propres aux Element comme :
//				// sélectionner un nœud fils, modifier du texte, etc...
//				Element courant = (Element) i.next();
//				// On affiche le nom de l’élément courant
//				if (courant.getAttribute("name").getValue().equals(psPlaylistName)){
//					courant.removeContent();
//				}
//			}
//			enregistre(fXmlDocument.getAbsolutePath());
//		}
//	}
	
	
}
