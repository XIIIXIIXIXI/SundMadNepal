package com.example.sundmadnepal.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.sundmadnepal.SundNepal.data.Recipe
import com.example.sundmadnepal.SundNepal.data.RecipeDatabase
import com.example.sundmadnepal.SundNepal.data.RecipeRepositoryImpl
import com.example.sundmadnepal.SundNepal.domain.repository.RecipeRepository
import com.example.sundmadnepal.SundNepal.domain.use_case.AddRecipe
import com.example.sundmadnepal.SundNepal.domain.use_case.GetRecipes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        app : Application ): RecipeDatabase {
        return Room.databaseBuilder(
            app,
            RecipeDatabase::class.java,
            "recipe_db"
        ).createFromAsset("database/recipe_db.db").build()
    }



 //provides repository for repository implementation

    @Provides
    @Singleton
    fun provideRecipeRepository(db: RecipeDatabase): RecipeRepository {
        // For test purposes switch this one out for a fake version of the database.
        //so instead of providing RecipeRepositoryImpl just provide a fake repository.
        return RecipeRepositoryImpl(db.dao)
    }
}
