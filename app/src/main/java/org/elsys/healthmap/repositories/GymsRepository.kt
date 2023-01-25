package org.elsys.healthmap.repositories

import android.annotation.SuppressLint
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import org.elsys.healthmap.models.Gym

class GymsRepository {
    companion object{
        private val db = FirebaseFirestore.getInstance()

        suspend fun getGyms(): Map<String, Gym>{
            val gyms = mutableMapOf<String, Gym>()

            db.collection("gyms")
                .get()
                .await()
                .documents.forEach {
                    val gymId = it.id
                    val gymData = it.toObject(Gym::class.java)

                    if (gymData != null) {
                        gyms[gymId] = gymData
                    }
                }

            return gyms;
        }

        suspend fun saveGym(id: String, gym: Gym) {
            db.collection("gyms")
                .document(id)
                .set(gym)
                .await()
        }
    }
}