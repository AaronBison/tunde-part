<template>
    <div id="app">
        <v-app-bar prominent src="https://cloudflare1.360gigapixels.com/pano/alienrc/00550669_vegsopano.jpg/equirect_crop_3_1/6.jpg"/>
        <v-app  style="background-color: #F7F7F7">
            <v-container class="my-5 " >
                <v-card id="card">
                    <v-card-title class="justify-center"> Jelszó megadása </v-card-title>
                    <v-divider class="mx-5 my-3"></v-divider>
                    <v-card-text class="mx-5">
                        Kedves Felhasználó! Regisztrációja véglegesítéséhez szükséges megadnia a jelszavát. 
                        Jelszó megadásakor a jelszóban kötelezően kell szerepeljen kis, nagy és szám karakter.
                    </v-card-text>
                    <v-flex xs12>
                        <v-text-field class="mx-5" name="password" v-model="password" label="Jelszó" color="grey"
                            prepend-icon="fas fa-lock"
                            :append-icon="show ? 'fas fa-eye' : 'fas fa-eye-slash'" 
                            @keyup.enter="validateUser" 
                            @click:append="show = !show"
                            :type="show ? 'text' : 'password'"
                            :rules="[value => !!value || 'A jelszó megadása kötelező!', 
                                    value => /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,20}$/.test(value) || 'A jelszó helytelen' , 
                                    value => value.length >= 5 || 'Legalább 5 karakter hosszúságú kell legyen']"/>
                    </v-flex>
                    <v-flex xs12>
                        <v-text-field class="mx-5" name="passwordAgain" v-model="passwordAgain" label="Jelszó újra" color="grey"
                            prepend-icon="fas fa-lock"
                            :append-icon="showAgain ? 'fas fa-eye' : 'fas fa-eye-slash'" 
                            @keyup.enter="validateUser" 
                            @click:append="showAgain = !showAgain"
                            :type="showAgain ? 'text' : 'password'"
                            :rules="[value => !!value || 'A jelszó megadása kötelező!', 
                                    value => /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,20}$/.test(value) || 'A jelszó helytelen' , 
                                    value => value.length >= 5 || 'Legalább 5 karakter hosszúságú kell legyen']"/>
                    </v-flex>
                    <v-card-actions class="justify-center">
                        <v-btn outlined color="#2B405D" class="mr-4"  text>Jelszó megerősítése</v-btn>
                    </v-card-actions>
                </v-card>
            </v-container>
        </v-app>
    </div>
</template>

<script>


export default {
  name: 'Password',
  data () {
    return {
        password: "",
        passwordAgain:"",
        show: false,
        showAgain: false,
    }
  }
}
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
</style>
