namespace GroceryStore
{
    partial class AdminPage
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(AdminPage));
            this.panel1 = new System.Windows.Forms.Panel();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.label1 = new System.Windows.Forms.Label();
            this.itemsBTN = new System.Windows.Forms.Button();
            this.salesBTN = new System.Windows.Forms.Button();
            this.reportBTN = new System.Windows.Forms.Button();
            this.button5 = new System.Windows.Forms.Button();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel3 = new System.Windows.Forms.Panel();
            this.inventoryBTN = new System.Windows.Forms.Button();
            this.sidePanel = new System.Windows.Forms.Panel();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.DarkOliveGreen;
            this.panel1.Controls.Add(this.sidePanel);
            this.panel1.Controls.Add(this.inventoryBTN);
            this.panel1.Controls.Add(this.button5);
            this.panel1.Controls.Add(this.reportBTN);
            this.panel1.Controls.Add(this.salesBTN);
            this.panel1.Controls.Add(this.itemsBTN);
            this.panel1.Controls.Add(this.label1);
            this.panel1.Controls.Add(this.pictureBox2);
            this.panel1.Location = new System.Drawing.Point(0, -2);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(138, 453);
            this.panel1.TabIndex = 0;
            // 
            // pictureBox2
            // 
            this.pictureBox2.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox2.Image")));
            this.pictureBox2.Location = new System.Drawing.Point(39, 13);
            this.pictureBox2.Margin = new System.Windows.Forms.Padding(2);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(54, 50);
            this.pictureBox2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.pictureBox2.TabIndex = 3;
            this.pictureBox2.TabStop = false;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.BlanchedAlmond;
            this.label1.Location = new System.Drawing.Point(25, 65);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(87, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Welcome Admin!";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // itemsBTN
            // 
            this.itemsBTN.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.itemsBTN.Location = new System.Drawing.Point(0, 146);
            this.itemsBTN.Name = "itemsBTN";
            this.itemsBTN.Size = new System.Drawing.Size(138, 39);
            this.itemsBTN.TabIndex = 1;
            this.itemsBTN.Text = "ITEMS";
            this.itemsBTN.UseVisualStyleBackColor = true;
            this.itemsBTN.Click += new System.EventHandler(this.salesBTN_Click);
            // 
            // salesBTN
            // 
            this.salesBTN.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.salesBTN.Location = new System.Drawing.Point(0, 236);
            this.salesBTN.Name = "salesBTN";
            this.salesBTN.Size = new System.Drawing.Size(138, 39);
            this.salesBTN.TabIndex = 7;
            this.salesBTN.Text = "SALES";
            this.salesBTN.UseVisualStyleBackColor = true;
            this.salesBTN.Click += new System.EventHandler(this.inventoryBTN_Click);
            // 
            // reportBTN
            // 
            this.reportBTN.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.reportBTN.Location = new System.Drawing.Point(0, 282);
            this.reportBTN.Name = "reportBTN";
            this.reportBTN.Size = new System.Drawing.Size(138, 39);
            this.reportBTN.TabIndex = 9;
            this.reportBTN.Text = "REPORTS";
            this.reportBTN.UseVisualStyleBackColor = true;
            this.reportBTN.Click += new System.EventHandler(this.reportBTN_Click);
            // 
            // button5
            // 
            this.button5.BackColor = System.Drawing.Color.BlanchedAlmond;
            this.button5.Font = new System.Drawing.Font("Microsoft YaHei", 6.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button5.Location = new System.Drawing.Point(32, 400);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(75, 25);
            this.button5.TabIndex = 10;
            this.button5.Text = "Log out";
            this.button5.UseVisualStyleBackColor = false;
            this.button5.Click += new System.EventHandler(this.button5_Click);
            // 
            // panel2
            // 
            this.panel2.BackColor = System.Drawing.Color.DarkSeaGreen;
            this.panel2.Controls.Add(this.panel3);
            this.panel2.Location = new System.Drawing.Point(138, 0);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(663, 451);
            this.panel2.TabIndex = 1;
            // 
            // panel3
            // 
            this.panel3.BackColor = System.Drawing.Color.Cornsilk;
            this.panel3.Location = new System.Drawing.Point(16, 16);
            this.panel3.Name = "panel3";
            this.panel3.Size = new System.Drawing.Size(631, 420);
            this.panel3.TabIndex = 0;
            // 
            // inventoryBTN
            // 
            this.inventoryBTN.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.inventoryBTN.Location = new System.Drawing.Point(0, 191);
            this.inventoryBTN.Name = "inventoryBTN";
            this.inventoryBTN.Size = new System.Drawing.Size(138, 39);
            this.inventoryBTN.TabIndex = 12;
            this.inventoryBTN.Text = "INVENTORY";
            this.inventoryBTN.UseVisualStyleBackColor = true;
            this.inventoryBTN.Click += new System.EventHandler(this.button1_Click);
            // 
            // sidePanel
            // 
            this.sidePanel.Location = new System.Drawing.Point(0, 143);
            this.sidePanel.Margin = new System.Windows.Forms.Padding(2);
            this.sidePanel.Name = "sidePanel";
            this.sidePanel.Size = new System.Drawing.Size(9, 42);
            this.sidePanel.TabIndex = 13;
            // 
            // AdminPage
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.panel1);
            this.Name = "AdminPage";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "AdminPage";
            this.Load += new System.EventHandler(this.AdminPage_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            this.panel2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button itemsBTN;
        private System.Windows.Forms.Button reportBTN;
        private System.Windows.Forms.Button salesBTN;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.Panel panel2;
        private System.Windows.Forms.Panel panel3;
        private System.Windows.Forms.Button inventoryBTN;
        private System.Windows.Forms.Panel sidePanel;
    }
}