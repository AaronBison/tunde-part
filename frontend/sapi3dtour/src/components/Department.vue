<template>
    <v-container class="justify-center" >
       <p>Tanszékek oldala</p>
    </v-container>
</template>

<script>
import AuthRequest from "@/services/AuthService";
import axios from "axios";

export default {
    name: 'Department',
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