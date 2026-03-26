package com.example.ideaspobloques.ui.categories

import android.os.Bundle
import androidx.`annotation`.CheckResult
import androidx.navigation.NavDirections
import com.example.ideaspobloques.R
import kotlin.Int
import kotlin.String

public class CategoriesFragmentDirections private constructor() {
  private data class ActionCategoriesToIdeas(
    public val categoryId: Int,
    public val categoryName: String,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_categories_to_ideas

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("categoryId", this.categoryId)
        result.putString("categoryName", this.categoryName)
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionCategoriesToIdeas(categoryId: Int, categoryName: String): NavDirections = ActionCategoriesToIdeas(categoryId, categoryName)
  }
}
