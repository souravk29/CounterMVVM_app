package eu.work.countermvvm_learn

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel(  ) : ViewModel() {

    private val _repository: CounterRepository = CounterRepository()                           // not used as parameter (changed)
    private val _count  = mutableStateOf(_repository.getCounter().count)                   //This is the private mutable state holding the current count.Only this ViewModel class can directly change _count.

    val count: MutableState<Int> = _count                                              // This line exposes _count's value to the outside (e.g., UI) through a public val named count, not its real identity

    fun increment(){
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }

    fun decrement(){
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }
    
}
