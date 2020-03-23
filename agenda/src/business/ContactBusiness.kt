package business

import entity.ContactEntity
import repository.ContactRepository
import java.lang.Exception

class ContactBusiness {
    fun save(name: String, phone: String) {
        validate(name, phone)
        val contact = ContactEntity(name, phone)

        ContactRepository.save(contact)
    }

    fun delete(name: String, phone: String) {
        validateDelete(name, phone)
        val contact = ContactEntity(name, phone);

        ContactRepository.delete(contact)
    }

    fun getList(): MutableList<ContactEntity> {
        return ContactRepository.getList()
    }

    private fun validateDelete(name: String, phone: String) {
        if (name == "" || phone == "") {
            throw Exception("É necessário selecionar um contato antes de remover")
        }
    }

    private fun validate(name: String, phone: String) {
        if (name == "") {
            throw Exception("Nome é obrigatório")
        }
        if (phone == "") {
            throw Exception("Nome é obrigatório")
        }
    }

    fun getContactCountDescription(): String{
        val list = getList()

        if(list.isEmpty()){
            return "0 Contatos"
        } else {
            return "${list.size} Contatos"
        }
    }
}