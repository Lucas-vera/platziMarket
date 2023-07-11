package com.platzi.cursoSpring.persistence.mapper;

import com.platzi.cursoSpring.domain.Product;
import com.platzi.cursoSpring.domain.Purchase;
import com.platzi.cursoSpring.persistence.entity.Compra;
import com.platzi.cursoSpring.persistence.entity.ComprasProducto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T12:22:52-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.1.1.jar, environment: Java 17 (Oracle Corporation)"
)
public class PurchaseMapperImpl implements PurchaseMapper {

    @Override
    public Purchase toPurchase(Compra compra) {
        if ( compra == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        if ( compra.getIdCompra() != null ) {
            purchase.setPurchaseId( compra.getIdCompra() );
        }
        purchase.setClient( compra.getIdCliente() );
        purchase.setDate( compra.getFecha() );
        purchase.setPaymentMethod( compra.getMedioPago() );
        purchase.setComment( compra.getComentario() );
        purchase.setState( compra.getEstado() );
        purchase.setProducts( comprasProductoListToProductList( compra.getProductos() ) );

        return purchase;
    }

    @Override
    public List<Purchase> toPurchases(List<Compra> compras) {
        if ( compras == null ) {
            return null;
        }

        List<Purchase> list = new ArrayList<Purchase>( compras.size() );
        for ( Compra compra : compras ) {
            list.add( toPurchase( compra ) );
        }

        return list;
    }

    @Override
    public Compra toCompra(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        Compra compra = new Compra();

        compra.setIdCompra( purchase.getPurchaseId() );
        compra.setIdCliente( purchase.getClient() );
        compra.setFecha( purchase.getDate() );
        compra.setMedioPago( purchase.getPaymentMethod() );
        compra.setComentario( purchase.getComment() );
        compra.setEstado( purchase.getState() );
        compra.setProductos( productListToComprasProductoList( purchase.getProducts() ) );

        return compra;
    }

    protected Product comprasProductoToProduct(ComprasProducto comprasProducto) {
        if ( comprasProducto == null ) {
            return null;
        }

        Product product = new Product();

        return product;
    }

    protected List<Product> comprasProductoListToProductList(List<ComprasProducto> list) {
        if ( list == null ) {
            return null;
        }

        List<Product> list1 = new ArrayList<Product>( list.size() );
        for ( ComprasProducto comprasProducto : list ) {
            list1.add( comprasProductoToProduct( comprasProducto ) );
        }

        return list1;
    }

    protected ComprasProducto productToComprasProducto(Product product) {
        if ( product == null ) {
            return null;
        }

        ComprasProducto comprasProducto = new ComprasProducto();

        return comprasProducto;
    }

    protected List<ComprasProducto> productListToComprasProductoList(List<Product> list) {
        if ( list == null ) {
            return null;
        }

        List<ComprasProducto> list1 = new ArrayList<ComprasProducto>( list.size() );
        for ( Product product : list ) {
            list1.add( productToComprasProducto( product ) );
        }

        return list1;
    }
}
