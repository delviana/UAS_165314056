
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Pojos.Pasien;
import Util.NewHibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Suster
 */
public class PasienHelper {

    public PasienHelper() {

    }

    public List<Pasien> bacaSemuaPasien() {
        List<Pasien> list = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Pasien p");
        list = q.list();
        tx.commit();
        session.close();
        return list;

    }

    public Pasien cariPasien(String nik) {
        // Create session
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        // Create String query
        String query = "from Pasien u where u.nik=:nik";
        Query q = session.createQuery(query);
        q.setParameter("nik", nik);
        // siapkan list,hasil pencarian dan panggil pencarian
        List<Pasien> list = q.list();
        // tutuup session
        session.close();

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }}
    public Pasien cariNama(String nama) {
        // Create session
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        // Create String query
        String query = "from Pasien u where u.nama=:nama";
        Query q = session.createQuery(query);
        q.setParameter("nama", nama);
        // siapkan list,hasil pencarian dan panggil pencarian
        List<Pasien> list = q.list();
        // tutuup session
        session.close();

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

   
}
