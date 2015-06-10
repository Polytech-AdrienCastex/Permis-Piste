package com.epul.permispiste.dao;

import org.hibernate.*;

import com.epul.permispiste.service.ServiceHibernate;
import com.epul.permispiste.gestiondeserreurs.MonException;
import com.epul.permispiste.gestiondeserreurs.ServiceHibernateException;
import metier.*;

import java.util.*;

public class HibernateClient {
	
	
	private List<Jeu> mesJeux = null;
	private Session session;

	// On r�cup�re toutes les lignes de la table dans une liste
	/*
	 * (non-Javadoc)
	 * 
	 * @see hibernate.service.InterfaceHibrnateStage#getTouteslesLignes()
	 */

	public List<Jeu> getTouteslesLignes() throws HibernateException,
			ServiceHibernateException {
		try {
			System.out.println("Get toutes les lignes :Je vais lire le fichier de conf ");
			session = ServiceHibernate.currentSession();
			// On passe une requ�te de type SQL mlais on travaille sur la classe
			Query query = session.createQuery("SELECT j  FROM Jeu AS j");
			mesJeux =  (List<Jeu>) query.list();
		} catch (Exception ex) {
			
			System.out.println("Erreur ServiceHiber : " + ex.getMessage());
			
			throw new MonException("Erreur  Hibernate: ",ex.getMessage());
		}
		return mesJeux;
	}

	// On r�cup�re une ligne avec une cl�

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hibernate.service.InterfaceHibrnateStage#getUneLigne(java.lang.String)
	 */

	public Jeu getUneLigne(int num) throws ServiceHibernateException ,Exception{
		boolean trouve = false;
		Jeu unJeu = null;
		try {
			mesJeux = getTouteslesLignes();
            int i =0;
			while (i < mesJeux.size() && !trouve) {
				unJeu = mesJeux.get(i);
				if (unJeu.getNumjeu() == num)
					trouve = true;
				i++;
			}
		} catch (ServiceHibernateException ex) {
			throw new ServiceHibernateException("Erreur de service Hibernate: "
					+ ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new MonException("Erreur  Hibernate: ", ex.getMessage());
		}
		return unJeu;
	}

	
}
