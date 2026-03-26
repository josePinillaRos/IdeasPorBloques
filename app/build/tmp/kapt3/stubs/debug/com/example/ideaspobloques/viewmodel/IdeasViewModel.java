package com.example.ideaspobloques.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\rJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00110\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/ideaspobloques/viewmodel/IdeasViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "categoryId", "Landroidx/lifecycle/MutableLiveData;", "", "getCategoryId", "()Landroidx/lifecycle/MutableLiveData;", "ideas", "Landroidx/lifecycle/MediatorLiveData;", "", "Lcom/example/ideaspobloques/data/entities/IdeaEntity;", "getIdeas", "()Landroidx/lifecycle/MediatorLiveData;", "ideasSource", "Landroidx/lifecycle/LiveData;", "query", "", "kotlin.jvm.PlatformType", "getQuery", "repo", "Lcom/example/ideaspobloques/repository/AppRepository;", "addIdea", "Lkotlinx/coroutines/Job;", "title", "description", "deleteIdea", "idea", "refreshIdeas", "", "setCategory", "id", "toggleDone", "app_debug"})
public final class IdeasViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.ideaspobloques.repository.AppRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> categoryId = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> query = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MediatorLiveData<androidx.lifecycle.LiveData<java.util.List<com.example.ideaspobloques.data.entities.IdeaEntity>>> ideasSource = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MediatorLiveData<java.util.List<com.example.ideaspobloques.data.entities.IdeaEntity>> ideas = null;
    
    public IdeasViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getCategoryId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MediatorLiveData<java.util.List<com.example.ideaspobloques.data.entities.IdeaEntity>> getIdeas() {
        return null;
    }
    
    private final void refreshIdeas() {
    }
    
    public final void setCategory(int id) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addIdea(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String description) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job toggleDone(@org.jetbrains.annotations.NotNull()
    com.example.ideaspobloques.data.entities.IdeaEntity idea) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteIdea(@org.jetbrains.annotations.NotNull()
    com.example.ideaspobloques.data.entities.IdeaEntity idea) {
        return null;
    }
}