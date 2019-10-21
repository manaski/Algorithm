package com.gangbin.设计模式;

/**
 * @author gangbin.li
 * @description: 一个产品有多个部分组成，这些部分分开建造，成为一个对象
 * @date 2019/10/16
 */
abstract class Builder{
    Builder(Product product){
        this.product=product;
    }
    Product product;
    public abstract void buildA();
    public abstract void buildB();
    public abstract void buildC();
}
class Director{
    Builder builder;
    Director(Builder builder){
        this.builder=builder;
    }
    public void doBuild(){
        builder.buildA();
        builder.buildB();
        builder.buildC();
    }
}
class ConcreteProcudtA implements Product{
    @Override
    public void show() {
        System.out.println("product"+" A");
    }
}
class ConcreteBuilder extends Builder{
    ConcreteBuilder(Product product) {
        super(product);
    }
    @Override
    public void buildA() {
        System.out.println("生产产品A。。。。。");
        product.show();
    }
    @Override
    public void buildB() {
        System.out.println("生产产品B。。。。。");
        product.show();
    }
    @Override
    public void buildC() {
        System.out.println("生产产品C。。。。。");
        product.show();
    }
}
public class 建造者模式 {
    public static void main(String[] args) {
        ConcreteProcudtA procudtA=new ConcreteProcudtA();
        ConcreteBuilder builder=new ConcreteBuilder(procudtA);
        Director director=new Director(builder);
        director.doBuild();
    }
}
