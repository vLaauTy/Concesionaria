
package com.concesionaria.concesionaria.controller;

import com.concesionaria.concesionaria.model.Auto;
import com.concesionaria.concesionaria.model.Vendedor;
import com.concesionaria.concesionaria.model.Venta;
import com.concesionaria.concesionaria.service.AutoService;
import com.concesionaria.concesionaria.service.VendedorService;
import com.concesionaria.concesionaria.service.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired
    private AutoService autoService;

    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private VentaService ventaService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("autos", autoService.findAll());
        model.addAttribute("vendedores", vendedorService.findAll());
        return "index"; // Nombre de la vista (index.html)
    }

    @GetMapping("/autos")
    public String listarAutos(Model model) {
        model.addAttribute("autos", autoService.findAll());
        return "autos"; // Nombre de la vista (autos.html)
    }

    @GetMapping("/autos/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("auto", new Auto());
        return "formulario_auto"; // Nombre de la vista (formulario_auto.html)
    }

    @PostMapping("/autos")
    public String guardarAuto(@ModelAttribute Auto auto) {
        autoService.save(auto);
        return "redirect:/autos";
    }

    @GetMapping("/autos/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("auto", autoService.findById(id));
        return "formulario_auto";
    }

    @GetMapping("/autos/eliminar/{id}")
    public String eliminarAuto(@PathVariable Long id) {
        autoService.deleteById(id);
        return "redirect:/autos";
    }

    @GetMapping("/vendedores")
    public String listarVendedores(Model model) {
        model.addAttribute("vendedores", vendedorService.findAll());
        return "vendedores"; // Nombre de la vista (vendedores.html)
    }

    @GetMapping("/vendedores/nuevo")
    public String mostrarFormularioVendedor(Model model) {
        model.addAttribute("vendedor", new Vendedor());
        return "formulario_vendedor"; // Nombre de la vista (formulario_vendedor.html)
    }

    @PostMapping("/vendedores")
    public String guardarVendedor(@ModelAttribute Vendedor vendedor) {
        vendedorService.save(vendedor);
        return "redirect:/vendedores";
    }

    @GetMapping("/vendedores/editar/{id}")
    public String mostrarFormularioEditarVendedor(@PathVariable Long id, Model model) {
        model.addAttribute("vendedor", vendedorService.findById(id));
        return "formulario_vendedor";
    }

    @GetMapping("/vendedores/eliminar/{id}")
    public String eliminarVendedor(@PathVariable Long id) {
        vendedorService.deleteById(id);
        return "redirect:/vendedores";
    }

    @GetMapping("/ventas")
    public String listarVentas(Model model) {
        model.addAttribute("ventas", ventaService.listarVentas());
        return "ventas"; // Nombre de la vista (ventas.html)
    }

    @GetMapping("/ventas/nuevo")
    public String mostrarFormularioVenta(Model model) {
        // Aquí deberías agregar la lógica para mostrar el formulario de venta
        // Por ejemplo, podrías agregar los autos y vendedores al modelo
        model.addAttribute("venta", new Venta());
        model.addAttribute("autos", autoService.findAll());
        model.addAttribute("vendedores", vendedorService.findAll());
        return "formulario_venta"; // Nombre de la vista (formulario_venta.html)
    }

    @PostMapping("/ventas")
    public String guardarVenta(@ModelAttribute Venta venta) {
        ventaService.guardarVenta(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/ventas/eliminar/{id}")
    public String eliminarVenta(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
        return "redirect:/ventas";
    }

    @GetMapping("/ventas/editar/{id}")
    public String mostrarFormularioEditarVenta(@PathVariable Long id, Model model) {

        model.addAttribute("venta", ventaService.obtenerVentaPorId(id));
        return "formulario_venta";
        // Redirigir si no se encuentra la venta
    }

}