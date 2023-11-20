# Example

### 1. Builder Item

```kotlin
class TitleItem(val title: String) : BuilderItem(title) {
    override fun getViewType() = R.layout.item_rv_one

    override fun render(holder: RvViewHolder) {
        holder.setText(R.id.tv_rv_item, title) // set text
    }

}
```


```kotlin
data class Description(val desp: String, val imageResId: Int)

class DescriptionItem(val despcription: Description) : BuilderItem(despcription) {
    override fun getViewType() = R.layout.item_desp

    override fun render(holder: RvViewHolder) {
        holder.setText(R.id.tvItem, despcription.desp)   // set text
        holder.setSrc(R.id.ivItem, despcription.imageResId) // set image
        holder.setClickListener(R.id.tvItem) {
            Toast.makeText(it.context, "click: ${despcription.desp}", Toast.LENGTH_SHORT).show()
        }
    }
}
```

### 2. Activity

```kotlin
class BuilderAdapterDemo : AppCompatActivity(R.layout.activity_rv) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rv.layoutManager = LinearLayoutManager(this)

        val wrapper = BuilderAdapterWrapper()

        wrapper.add(TitleItem("views"))
        wrapper.add(DescriptionItem(Description("scratch card", R.drawable.photo4)))
        wrapper.add(DescriptionItem(Description("jimu rv", R.drawable.photo5)))

        wrapper.add(TitleItem("recyclerviews"))
        wrapper.add(DescriptionItem(Description("folder view", R.drawable.food)))
        wrapper.add(DescriptionItem(Description("tiger", R.drawable.little_tiger)))

        wrapper.add(TitleItem("photos"))
        wrapper.add(DescriptionItem(Description("scope", R.drawable.photo1)))
        wrapper.add(DescriptionItem(Description("hill", R.drawable.photo2)))
        wrapper.add(DescriptionItem(Description("lake", R.drawable.photo3)))

        rv.adapter = wrapper.generateAdapter()

    }
}
```