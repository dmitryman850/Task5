package dmitry.man.task5mycat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CatViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Cats>>()
        val items: LiveData<List<Cats>> get() = _items

    init {
        viewModelScope.launch {
            _items.value = CatApiImpl.getListOfCats()
        }
    }
}
