package com.example.simpleviewmodelkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonViewModel : ViewModel() {

    val person: MutableLiveData<Person> = MutableLiveData()
    val name: MutableLiveData<String> = MutableLiveData()
    val age: MutableLiveData<Int> = MutableLiveData()
    val salary: MutableLiveData<Int> = MutableLiveData()


}