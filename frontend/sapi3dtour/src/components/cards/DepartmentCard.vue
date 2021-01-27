<template>
    <v-card id="card" width="1000" class="mx-3 my-3" elevation="10" >
        <v-card-title class="justify-center">
            <a v-bind:href="card.link" target="_blank">{{ card.departmentName }}</a>
         </v-card-title>

        <v-divider class="mx-5 my-3"></v-divider>

        <v-card-subtitle color="#2B405D"> Szakok </v-card-subtitle>

        <v-row class="justify-center">
            <v-col>
                <v-list-item center class="mx-5">
                    <v-list-item-icon>
                        <v-icon> fas fa-envelope </v-icon>
                    </v-list-item-icon>
                    <v-list-item-content>
                        <v-list-item-title v-text=card.link ></v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-col>
            <v-col>
                <v-list-item center class="mx-5">
                    <v-list-item-icon>
                        <v-btn icon href="https://www.google.com/maps/?hl=HU">
                            <v-icon>fas fa-map-marked-alt</v-icon>
                        </v-btn>
                    </v-list-item-icon>
                    <v-list-item-content>
                        <v-list-item-title> terem</v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-col>
        </v-row>

        <v-divider class="mx-5 my-3"></v-divider>

        <v-card-subtitle color="#2B405D"> Egyebek </v-card-subtitle>

        
    </v-card>
</template>

<script>

export default {
    name: 'DepartmentCard',
    props: ["card"],
    data () {
        return {
        };
    }
}
</script>

<style>
    #card {
        background-color: #E1E1DE;
        color: #2B405D;
    }
</style>