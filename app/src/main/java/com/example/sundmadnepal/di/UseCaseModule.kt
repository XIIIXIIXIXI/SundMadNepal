package com.example.sundmadnepal.di

import android.app.Application
import androidx.room.Room
import com.example.sundmadnepal.SundNepal.data.RecipeDao
import com.example.sundmadnepal.SundNepal.data.RecipeDatabase
import com.example.sundmadnepal.SundNepal.data.RecipeRepositoryImpl
import com.example.sundmadnepal.SundNepal.domain.repository.RecipeRepository
import com.example.sundmadnepal.SundNepal.domain.use_case.AddRecipe
import com.example.sundmadnepal.SundNepal.domain.use_case.GetRecipes
import com.example.sundmadnepal.SundNepal.domain.use_case.RecipeUseCases
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Provides
    @Singleton
    fun provideRecipeDatabase(app : Application): RecipeDatabase {
        return Room.databaseBuilder(
            app,
            RecipeDatabase::class.java,
            RecipeDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(db: RecipeDatabase): RecipeRepository {
        // For test purposes switch this one out for a fake version of the database.
        //so instead of providing RecipeRepositoryImpl just provide a fake repository.
        return RecipeRepositoryImpl(db.recipeDao)
    }

    /**
     * Inject this class into the viewmodel and inject the usecases aswell.
     */
    @Provides
    @Singleton
    fun provideRecipeUseCases(repository: RecipeRepository): RecipeUseCases {
        return RecipeUseCases(
            getRecipes = GetRecipes(repository),
            addRecipe = AddRecipe(repository)
        )
    }
}
