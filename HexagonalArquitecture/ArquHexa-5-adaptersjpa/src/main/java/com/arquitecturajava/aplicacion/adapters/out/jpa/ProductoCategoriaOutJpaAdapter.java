package com.arquitecturajava.aplicacion.adapters.out.jpa;

import java.util.ArrayList;
import java.util.List;

import com.arquitecturajava.aplicacion.adapters.out.jpa.repositories.CategoriaProductoRepository;
import com.arquitecturajava.aplicacion.adapters.out.jpa.repositories.ProductoRepository;
import com.arquitecturajava.aplicacion.dominio.Categoria;
import com.arquitecturajava.aplicacion.dominio.Producto;
import com.arquitecturajava.aplicacion.ports.out.BuscarCategoriasOut;
import com.arquitecturajava.aplicacion.ports.out.BuscarProductosOut;
import com.arquitecturajava.aplicacion.ports.out.NuevoProductoOut;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class ProductoCategoriaOutJpaAdapter 
implements BuscarCategoriasOut,NuevoProductoOut,BuscarProductosOut{
	/*esto es un proceso parcial en el que vamos 
	a gusrdar primero en memoria antes de ver como usar 
	otras herramientas de persistencia */
	//eliminamos el entitymanager em que tendermos en el old pero si tiene que dejar por
	private final EntityManager em;
	
	ProductoRepository productoRepository;
	CategoriaProductoRepository categoriaProductoRepository;
	
	public ProductoCategoriaOutJpaAdapter(EntityManager em,ProductoRepository productoRepository, CategoriaProductoRepository categoriaProductoRepository ) {
		super();
		this.productoRepository= productoRepository;
		this.categoriaProductoRepository = categoriaProductoRepository;
		this.em = em;
	}
	/*producto es una clase de dominio por lo que no puede ser persistida
	 * necesitamos una entidad
	 */
	@Override
	public void salvarProducto(Producto producto) {
		ProductoEntity productoEntity = new ProductoEntity();
		productoEntity.setNumeroSerie(producto.getNumeroSerie());
		productoEntity.setNombre(producto.getNombre());
		productoEntity.setPrecio(producto.getPrecio());
		/*CategoriaProductoEntity categoriaEntity = new CategoriaProductoEntity();
		categoriaEntity.setId(producto.getCategoria().getId());
		productoEntity.setCategoria(categoriaEntity);*/
		CategoriaProductoEntity categoriaEntity = em.find(CategoriaProductoEntity.class, producto.getCategoria().getId());
	    productoEntity.setCategoria(categoriaEntity);
		productoRepository.salvar(productoEntity);
	}
	/*para esto los objetos se hna relacionado 
	 * Lo que estamos haciendo es cambiar la filosofia de persistir mediante memoria 
	 * a persisitir mediante bbdd y jpa 
	 */
	@Override
	public void asignarCategoriaProducto(Producto producto, Categoria categoria) {
		
		/*ProductoEntity productoEntity = em.find(ProductoEntity.class, producto.getNumeroSerie());
		CategoriaProductoEntity categoriaEntity = em.find(CategoriaProductoEntity.class, categoria.getId());
		productoEntity.setCategoria(categoriaEntity);
		em.merge(productoEntity);
		em.merge(categoriaEntity);*/
		producto.setCategoria(categoria);
	}

	@Override
	public List<Categoria> buscarTodas() {
		List <CategoriaProductoEntity> listaEntidades = categoriaProductoRepository.buscartodos();
		List <Categoria> categoriaDominio = new ArrayList<Categoria>();
		for(CategoriaProductoEntity cpe:listaEntidades) {
			categoriaDominio.add(new Categoria(cpe.getId(),cpe.getNombre()));
			
		}
		return categoriaDominio;
	}
	/*
	 * se usa la clase productoEntity porque esa es la clase de persistencia 
	 */
	@Override
	public List<Producto> buscarTodos() {
		List <ProductoEntity> listaEntidades = productoRepository.buscarTodo();
		List <Producto> listaDominio = new ArrayList<Producto>();
		for(ProductoEntity pe:listaEntidades) {
			listaDominio.add(new Producto (pe.getNumeroSerie(),pe.getNombre(),pe.getPrecio()));
			
		}
		return listaDominio;
	}
}