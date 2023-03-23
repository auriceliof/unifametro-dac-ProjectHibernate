package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Pessoa;
import util.JPAUtil;

public class PessoaDao {
	
	public static void salvar(Pessoa p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void atualizar(Pessoa p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void deletar(Pessoa p) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		p = em.find(Pessoa.class, p.getChave());
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Pessoa acharPorChave(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Pessoa p = em.find(Pessoa.class, id);
		em.close();
		return p;
	}
	
	public static List<Pessoa> acharTodos(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select p from Pessoa p");
		List<Pessoa> pessoas = q.getResultList();
		em.close();
		return pessoas;
	}
}
