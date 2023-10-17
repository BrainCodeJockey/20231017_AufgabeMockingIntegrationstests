package de.unmuth.products;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    IdService idService = Mockito.mock(IdService.class);
    ProductService productService = new ProductService(productRepository, idService);


    @Test
    void givenAvailableProducts_whenFindAll_thenReturnsAllProducts() {
        //GIVEN
        Product p1 = new Product("1", "product1", 2);
        List<Product> productList = List.of(p1);

        when(productRepository.findAll()).thenReturn(productList);

        //WHEN
        List<Product> actual = productService.findAllProducts();

        //THEN
        List<Product> expected = List.of(new Product("1", "product1", 2));

        verify(productRepository).findAll();
        assertEquals(expected, actual);
    }

    @Test
    void givenNewProductDetails_whenAddProduct_thenProductIsSaved() {
        //GIVEN

        NewProduct newProduct = new NewProduct("product1", 30);
        Product savedProduct = new Product("123", "product1", 30);

        when(idService.randomId()).thenReturn("123");
        when(productRepository.save(savedProduct)).thenReturn(savedProduct);

        //WHEN
        Product actual = productService.addProduct(newProduct);

        //THEN
        Product expected = new Product("123", "product1", 30);
        verify(productRepository).save(savedProduct);
        verify(idService).randomId();
        assertEquals(expected, actual);
    }

    @Test
    void givenProductId_whenFindById_thenReturnsProduct() {
        //GIVEN
        String id = "3";
        Product product = new Product("3", "product3", 3);

        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        //WHEN

        Product actual = productService.findById(id);

        //THEN
        Product expected = new Product("3", "product3", 3);
        verify(productRepository).findById(id);
        assertEquals(expected, actual);
    }

    @Test
    void givenInvalidProductId_whenFindById_thenThrowsException() {
        //GIVEN
        String id = "3";
        Product product = new Product("3", "product3", 3);

        //WHEN
        when(productRepository.findById(id)).thenReturn(Optional.empty());

        //THEN
        assertThrows(NoSuchElementException.class, () -> productService.findById(id));
    }

    @Test
    void givenProductIdAndProductDetails_whenUpdateProduct_thenProductIsUpdated() {
        // GIVEN
        NewProduct newProduct = new NewProduct("Apfel", 30);
        Product savedProduct = new Product("1", "Apfel", 30);
        when(productRepository.save(savedProduct)).thenReturn(savedProduct);

        // WHEN
        Product actual = productService.updateProduct("1", newProduct);

        // THEN
        verify(productRepository).save(savedProduct);
        assertEquals(savedProduct, actual);
    }

    @Test
    void givenProductId_whenDeleteProduct_thenProductIsDeleted() {
        //GIVEN
        String id = "1";
        doNothing().when(productRepository).deleteById("1");

        //WHEN
        productService.deleteProduct(id);

        //THEN
        verify(productRepository).deleteById(id);
    }
}