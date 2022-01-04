package com.salaheddin.currencyconverter.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ/\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/salaheddin/currencyconverter/network/NewsAPI;", "", "getBreakingNews", "", "countryCode", "", "page", "apiKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchForNews", "app_debug"})
public abstract interface NewsAPI {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "v2/top-headlines")
    public abstract java.lang.Object getBreakingNews(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "country")
    java.lang.String countryCode, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "page")
    java.lang.String page, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apiKey")
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "v2/everything")
    public abstract java.lang.Object searchForNews(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q")
    java.lang.String countryCode, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "page")
    java.lang.String page, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "apiKey")
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 3)
    public final class DefaultImpls {
    }
}