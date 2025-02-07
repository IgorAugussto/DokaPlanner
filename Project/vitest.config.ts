import { fileURLToPath } from 'node:url'
import { mergeConfig, defineConfig, configDefaults } from 'vitest/config'
import viteConfig from './vite.config'
import tailwindcss from '@tailwindcss/vite'

export default mergeConfig(
  viteConfig,
  defineConfig({
    plugins: [
      tailwindcss(),
    ],
    test: {
      environment: 'jsdom',
      exclude: [...configDefaults.exclude, 'e2e/**'],
      root: fileURLToPath(new URL('./', import.meta.url)),
    },
    server: {
      allowedHosts: [
        'https://1583-2804-18-132-1cc9-2c83-b38e-66b1-d0bc.ngrok-free.app', // Domínio do Ngrok
      ],
    },
  }),
)
