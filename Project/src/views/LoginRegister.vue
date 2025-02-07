<template>
  <div class="flex items-center justify-center min-h-screen bg-gray-100">
    <div class="w-full max-w-md p-6 bg-white rounded-2xl shadow-md">
      <h2 class="text-2xl font-semibold text-center text-gray-800 mb-6">
        Cadastro
      </h2>

      <form @submit.prevent="register" class="space-y-4">
        <div>
          <label for="name" class="block text-sm font-medium text-gray-700">
            Nome
          </label>
          <input
            v-model="name"
            type="text"
            id="name"
            class="w-full px-4 py-2 mt-2 border rounded-lg shadow-sm focus:ring focus:ring-indigo-200 focus:outline-none"
          />
        </div>

        <div>
          <label for="age" class="block text-sm font-medium text-gray-700">
            Idade
          </label>
          <input
            v-model="age"
            type="number"
            id="age"
            class="w-full px-4 py-2 mt-2 border rounded-lg shadow-sm focus:ring focus:ring-indigo-200 focus:outline-none"
          />
        </div>

        <div>
          <label for="email" class="block text-sm font-medium text-gray-700">
            Email
          </label>
          <input
            v-model="email"
            type="email"
            id="email"
            class="w-full px-4 py-2 mt-2 border rounded-lg shadow-sm focus:ring focus:ring-indigo-200 focus:outline-none"
          />
        </div>

        <div>
          <label for="password" class="block text-sm font-medium text-gray-700">
            Senha
          </label>
          <input
            v-model="password"
            type="password"
            id="password"
            class="w-full px-4 py-2 mt-2 border rounded-lg shadow-sm focus:ring focus:ring-indigo-200 focus:outline-none"
          />
        </div>

        <div>
          <label for="team" class="block text-sm font-medium text-gray-700">
            Selecione uma equipe
          </label>
          <select
            v-model="team"
            id="team"
            class="w-full px-4 py-2 mt-2 border rounded-lg shadow-sm focus:ring focus:ring-indigo-200 focus:outline-none"
          >
            <option value="">Escolha...</option>
            <option value="doka">Doka</option>
            <option value="wave">Wave</option>
            <option value="mais-perto">+Perto</option>
          </select>
        </div>

        <BaseButton type="submit">Cadastrar</BaseButton>
      </form>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import BaseButton from '@/components/BaseButton.vue'

const name = ref('');
const age = ref<number | null>(null);
const email = ref('');
const password = ref('');
const team = ref('');

const register = () => {
  console.log('Nome:', name.value);
  console.log('Idade:', age.value);
  console.log('Email:', email.value);
  console.log('Senha:', password.value);
  console.log('Equipe:', team.value);
};
</script>
