package com.example.sundmadnepal.di

import com.example.sundmadnepal.SundNepal.domain.repository.RecipesRepository
import com.example.sundmadnepal.SundNepal.domain.use_case.ShowRecipes
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun showRecipes(
        RecipesRepository : ShowRecipes
    ): RecipesRepository
}
