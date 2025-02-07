<template>
  <div class="flex items-center justify-center min-h-screen bg-gray-100">
    <div class="w-full max-w-sm p-6 bg-white rounded-2xl shadow-md">
      <h2 class="text-2xl font-semibold text-center text-gray-800 mb-6">Login</h2>

      <form @submit.prevent="login" class="space-y-4">
        <div>
          <label for="email" class="block text-sm font-medium text-gray-700">Email</label>
          <input v-model="email" type="email" id="email" required
            class="w-full px-4 py-2 mt-2 border rounded-lg shadow-sm focus:ring focus:ring-indigo-200 focus:outline-none">
        </div>

        <div>
          <label for="password" class="block text-sm font-medium text-gray-700">Senha</label>
          <input v-model="password" type="password" id="password" required
            class="w-full px-4 py-2 mt-2 border rounded-lg shadow-sm focus:ring focus:ring-indigo-200 focus:outline-none">
        </div>

        <BaseButton type="submit">Entrar</BaseButton>

      </form>
      <p class="mt-2 text-center text-sm text-gray-500">
        <RouterLink to="/forgot-password" class="hover:underline">Esqueceu sua senha?</RouterLink>
      </p>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import BaseButton from '@/components/BaseButton.vue'

const email = ref('')
const password = ref('')

const login = () => {
  console.log('Email:', email.value)
  console.log('Senha:', password.value)
}
</script>
