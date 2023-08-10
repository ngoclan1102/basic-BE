package com.shop.be.Constant;

public class Constant {
    public static final class Account{
        public static final String createFail = "Create account fail!!!";
        public static final String findAccountFail = "Account cannot be found!!!";
        public static final String wrongAccount = "Username or password is wrong!!!";

        private Account() {
        }
    }

    public static final class Cart{
        public static final String addCartFail = "Can't add products to cart!!!";
        public static final String deleteCartFail = "Can't delete products in cart!!!";
        public static final String createCartFail = "Can't create list cart!!!";

        private Cart() {
        }
    }

    public static final class Wishlist{
        public static final String addWishlistFail = "Can't add products to wishlist!!!";
        public static final String createWishlistFail = "Can't create wishlist!!!";
        public static final String deleteWishlistFail = "Can't delete products in wishlist!!!";

        private Wishlist() {
        }
    }

    public static final class Product{
        public static final String findAccountFail = "Product cannot be found!!!";

        private Product() {
        }
    }

    public static final String Success = "Success!!";
}
